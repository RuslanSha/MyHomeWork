package my_tests;

import org.junit.jupiter.api.Test;

public class MyContactCreationTests extends TestBase {

    @Test
    public void canCreateMyContact() {
        my_app.my_contacts().openMyContactsPage();
        my_app.my_contacts().createMyContact();
    }
}
