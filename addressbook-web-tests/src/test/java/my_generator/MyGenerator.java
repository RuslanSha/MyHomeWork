package my_generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import my_common.MyCommonFunctions;
import my_model.ContactData;
import my_model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MyGenerator {
    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-n"})
    int count;

    public static void main(String[] args) throws IOException {
        var my_generator = new MyGenerator();
        JCommander.newBuilder()
                .addObject(my_generator)
                .build()
                .parse(args);
        my_generator.run();
    }

    private void run() throws IOException {
        var my_data = generate();
        save(my_data);
    }

    private Object generate() {
        if ("contacts".equals(type)) {
            return generateContacts();
        } else if ("groups".equals(type)) {
            return generateGroups();
        } else {
            throw new IllegalArgumentException("Unknown data type " + type);
        }
    }

    private Object generateContacts() {
        var my_contacts = new ArrayList<ContactData>();
        for (int i = 1; i <= count; i++) {
            my_contacts.add(new ContactData()
                    .withFirstname(MyCommonFunctions.randomString(i * 2))
                    .withMiddlename(MyCommonFunctions.randomString(i * 2))
                    .withLastname(MyCommonFunctions.randomString(i * 3))
                    .withNickname(MyCommonFunctions.randomString(i * 2))
                    .withTitle(MyCommonFunctions.randomString(i * 2))
                    .withCompany(MyCommonFunctions.randomString(i * 4))
                    .withAddress(MyCommonFunctions.randomString(i * 5))
                    .withMobile(MyCommonFunctions.randomNumber(11))
                    .withEmail(String.format("%s@%s.info",
                            MyCommonFunctions.randomString(i * 2),
                            MyCommonFunctions.randomString(i * 2)))
                    .withPhoto(MyCommonFunctions.randomFile("src/test/resources/images")));
        }
        return my_contacts;
    }

    private Object generateGroups() {
        var my_groups = new ArrayList<GroupData>();
        for (int i = 1; i <= count; i++) {
            my_groups.add(new GroupData()
                    .withName(MyCommonFunctions.randomString(i * 3))
                    .withHeader(MyCommonFunctions.randomString(i * 3))
                    .withFooter(MyCommonFunctions.randomString(i * 3)));
        }
        return my_groups;
    }

    private void save(Object my_data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper my_mapper = new ObjectMapper();
            my_mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var my_json = my_mapper.writeValueAsString(my_data);
            try (var writer = new FileWriter(output)) {
                writer.write(my_json);
            }
        } else if ("yaml".equals(format)) {
            var my_mapper = new YAMLMapper();
            my_mapper.writeValue(new File(output), my_data);
        } else if ("xml".equals(format)) {
            var my_mapper = new XmlMapper();
            my_mapper.writeValue(new File(output), my_data);
        } else {
            throw new IllegalArgumentException("Unknown data format " + format);
        }
    }

}
