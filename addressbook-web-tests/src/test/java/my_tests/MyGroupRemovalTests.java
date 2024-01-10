package my_tests;

import org.junit.jupiter.api.Test;

public class MyGroupRemovalTests extends TestBase {

    @Test
    public void canRemoveMyGroup() {
        my_app.my_groups().openMyGroupsPage();
        if (!my_app.my_groups().isMyGroupPresent()) {
            my_app.my_groups().createMyGroup();
        }
        my_app.my_groups().removeMyGroup();
    }
}
