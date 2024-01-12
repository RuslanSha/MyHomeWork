package my_tests;

import my_model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.ArrayList;

public class MyGroupRemovalTests extends TestBase {

    @Test
    public void canRemoveMyGroup() {
        if (my_app.my_groups().getMyGroupsCount() == 0) {
            my_app.my_groups().createMyGroup(new GroupData("",
                    "group name",
                    "group header",
                    "group footer"));
        }
        var myOldGroups = my_app.my_groups().getMyGroupList();
        var my_rnd = new Random();
        var my_index = my_rnd.nextInt(myOldGroups.size());
        my_app.my_groups().removeMyGroup(myOldGroups.get(my_index));
        var myNewGroups = my_app.my_groups().getMyGroupList();
        var myExpectedList = new ArrayList<>(myOldGroups);
        myExpectedList.remove(my_index);
        Assertions.assertEquals(myNewGroups, myExpectedList);
    }
}
