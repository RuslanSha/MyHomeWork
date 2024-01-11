package my_tests;

import my_model.ContactData;
import org.junit.jupiter.api.Test;

public class MyContactRemovalTests extends TestBase {

    @Test
    public void canRemoveMyContact() {
        if (!my_app.my_contacts().isMyContactPresent()) {
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
        my_app.my_contacts().removeMyContact();
    }
}
