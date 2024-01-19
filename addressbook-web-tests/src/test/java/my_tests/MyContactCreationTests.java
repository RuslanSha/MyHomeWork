package my_tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import my_model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyContactCreationTests extends TestBase {

    public static List<ContactData> myContactProvider() throws IOException {
        var my_contacts = new ArrayList<ContactData>();
        var myContactJson = Files.readString(Paths.get("my_contacts.json"));
        ObjectMapper myContactMapper = new ObjectMapper();
        var myContactValue = myContactMapper.readValue(myContactJson, new TypeReference<List<ContactData>>() {});
        my_contacts.addAll(myContactValue);
        return my_contacts;
    }

    @ParameterizedTest
    @MethodSource("myContactProvider")
    public void canCreateMyMultipleContact(ContactData my_contact) {
        var myOldContacts = my_app.my_jdbc().getMyContactList();
        my_app.my_contacts().createMyContact(my_contact);
        var myNewContacts = my_app.my_jdbc().getMyContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.my_id()), Integer.parseInt(o2.my_id()));
        };
        myNewContacts.sort(compareById);
        var myMaxId = myNewContacts.get(myNewContacts.size() - 1).my_id();

        var myExpectedList = new ArrayList<>(myOldContacts);
        myExpectedList.add(my_contact.withId(myMaxId).withPhoto(""));
        myExpectedList.sort(compareById);
        Assertions.assertEquals(myNewContacts, myExpectedList);
    }
}
