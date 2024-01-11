package my_tests;

import my_model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyContactRemovalTests extends TestBase {

    @Test
    public void canRemoveMyContact() {
        if (my_app.my_contacts().getMyContactsCount() == 0) {
            my_app.my_contacts().createMyContact(new ContactData("my_firstname",
                    "my_middlename",
                    "my_lastname",
                    "my_nickname",
                    "my_title",
                    "my_company",
                    "my_address",
                    "81236669977",
                    "my_email@my_domain"));
        }
        int myContactsCount = my_app.my_contacts().getMyContactsCount();
        my_app.my_contacts().removeMyContact();
        int myNewContactsCount = my_app.my_contacts().getMyContactsCount();
        Assertions.assertEquals(myContactsCount - 1, myNewContactsCount);
    }
}
