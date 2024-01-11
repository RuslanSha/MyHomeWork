package my_tests;

import my_model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class MyContactCreationTests extends TestBase {

    public static List<ContactData> myContactProvider() {
        var result = new ArrayList<ContactData>();
        for (int i = 2; i < 4; i++) {
            result.add(new ContactData(randomString(i * 2),
                    randomString(i * 2),
                    randomString(i * 3),
                    randomString(i * 2),
                    randomString(i * 2),
                    randomString(i * 4),
                    randomString(i * 5),
                    randomNumber(11),
                    randomString(i * 2) + '@' + randomString(i * 2)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("myContactProvider")
    public void canCreateMyMultipleContact(ContactData my_contact) {
        int myContactsCount = my_app.my_contacts().getMyContactsCount();
        my_app.my_contacts().createMyContact(my_contact);
        int myNewContactsCount = my_app.my_contacts().getMyContactsCount();
        Assertions.assertEquals(myContactsCount + 1, myNewContactsCount);
    }
}
