package my_tests;

import org.junit.jupiter.api.Test;

public class MyGroupCreationTests extends TestBase {

    @Test
    public void canCreateMyGroup() {
        my_app.my_groups().openMyGroupsPage();
        my_app.my_groups().createMyGroup();
    }
}
