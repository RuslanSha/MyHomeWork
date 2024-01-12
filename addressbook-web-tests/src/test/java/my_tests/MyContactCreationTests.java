package my_tests;

import my_model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyContactCreationTests extends TestBase {

    public static List<ContactData> myContactProvider() {
        var result = new ArrayList<ContactData>();
        for (int i = 2; i < 4; i++) {
            result.add(new ContactData("",
                    randomString(i * 2),
                    randomString(i * 2),
                    randomString(i * 3),
                    randomString(i * 2),
                    randomString(i * 2),
                    randomString(i * 4),
                    randomString(i * 5),
                    randomNumber(11),
                    String.format("%s@%s.info", randomString(i * 2), randomString(i * 2))));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("myContactProvider")
    public void canCreateMyMultipleContact(ContactData my_contact) {
        var myOldContacts = my_app.my_contacts().getMyContactList();
        my_app.my_contacts().createMyContact(my_contact);
        var myNewContacts = my_app.my_contacts().getMyContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.my_id()), Integer.parseInt(o2.my_id()));
        };
        myNewContacts.sort(compareById);
        var myExpectedList = new ArrayList<>(myOldContacts);
        myExpectedList.add(my_contact.withId(myNewContacts.get(myNewContacts.size() - 1).my_id())
                .withFirstname("")
                .withMiddlename("")
                .withLastname("")
                .withNickname("")
                .withTitle("")
                .withCompany("")
                .withAddress("")
                .withMobile("")
        );
        myExpectedList.sort(compareById);
        Assertions.assertEquals(myNewContacts, myExpectedList);
    }
}
