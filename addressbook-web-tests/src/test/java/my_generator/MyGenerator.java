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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class MyGenerator {
    @Parameter(names = {"--properties", "-p"})
    String properties_file;

    private String contact_file;
    private String group_file;
    private String format;
    private int count;

    private Properties my_properties;

    public static void main(String[] args) throws IOException {
        var my_generator = new MyGenerator();
        JCommander.newBuilder()
                .addObject(my_generator)
                .build()
                .parse(args);
        my_generator.run();
    }

    private void run() throws IOException {
        my_properties = new Properties();
        my_properties.load(new FileReader(System.getProperty("target", properties_file)));

        contact_file = my_properties.getProperty("file.contacts");
        group_file = my_properties.getProperty("file.groups");
        format = my_properties.getProperty("file.format");
        count = Integer.parseInt(my_properties.getProperty("file.count"));

        var my_contactData = generateContacts();
        var my_contactOut = contact_file + "." + format;
        save(my_contactData, my_contactOut);

        var my_groupData = generateGroups();
        var my_groupOut = group_file + "." + format;
        save(my_groupData, my_groupOut);
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
                    .withPhoto(MyCommonFunctions.randomFile(my_properties.getProperty("file.photoDir"))));
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

    private void save(Object my_data, String my_output) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper my_mapper = new ObjectMapper();
            my_mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var my_json = my_mapper.writeValueAsString(my_data);
            try (var writer = new FileWriter(my_output)) {
                writer.write(my_json);
            }
        } else if ("yaml".equals(format)) {
            var my_mapper = new YAMLMapper();
            my_mapper.writeValue(new File(my_output), my_data);
        } else if ("xml".equals(format)) {
            var my_mapper = new XmlMapper();
            my_mapper.writeValue(new File(my_output), my_data);
        } else {
            throw new IllegalArgumentException("Unknown data format " + format);
        }
    }

}
