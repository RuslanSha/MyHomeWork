package my_tests;

import my_model.GroupData;
import org.junit.jupiter.api.Test;

public class MyGroupRemovalTests extends TestBase {

    @Test
    public void canRemoveMyGroup() {
        if (!my_app.my_groups().isMyGroupPresent()) {
            my_app.my_groups().createMyGroup(new GroupData("group name", "group header", "group footer"));
        }
        my_app.my_groups().removeMyGroup();
    }
}
