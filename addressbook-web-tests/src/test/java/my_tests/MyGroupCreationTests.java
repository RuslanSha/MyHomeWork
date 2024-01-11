package my_tests;

import my_model.GroupData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyGroupCreationTests extends TestBase {

    @Test
    public void canCreateMyGroup() {
        my_app.my_groups().createMyGroup(new GroupData("group name", "group header", "group footer"));
    }
}
