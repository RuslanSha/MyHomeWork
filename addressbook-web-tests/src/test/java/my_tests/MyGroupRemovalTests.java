package my_tests;

import my_model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyGroupRemovalTests extends TestBase {

    @Test
    public void canRemoveMyGroup() {
        if (my_app.my_groups().getMyGroupsCount() == 0) {
            my_app.my_groups().createMyGroup(new GroupData("group name", "group header", "group footer"));
        }
        int myGroupsCount = my_app.my_groups().getMyGroupsCount();
        my_app.my_groups().removeMyGroup();
        int myNewGroupsCount = my_app.my_groups().getMyGroupsCount();
        Assertions.assertEquals(myGroupsCount - 1, myNewGroupsCount);
    }
}
