package my_tests;

import org.junit.jupiter.api.Test;

public class MyContactRemovalTests extends TestBase {

    @Test
    public void canRemoveMyContact() {
        my_app.my_contacts().openMyContactsPage();
        if (!my_app.my_contacts().isMyContactPresent()) {
            my_app.my_contacts().createMyContact();
        }
        my_app.my_contacts().removeMyContact();
    }
}
