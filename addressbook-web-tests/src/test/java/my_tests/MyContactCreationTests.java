package my_tests;

import my_model.ContactData;
import org.junit.jupiter.api.Test;

public class MyContactCreationTests extends TestBase {

    @Test
    public void canCreateMyContact() {
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
}
