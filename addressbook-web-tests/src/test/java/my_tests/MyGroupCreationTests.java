package my_tests;

import my_model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class MyGroupCreationTests extends TestBase {

    public static List<GroupData> myGroupProvider() {
        var result = new ArrayList<GroupData>();
        for (int i = 2; i < 5; i++) {
            result.add(new GroupData(randomString(i * 3),
                    randomString(i * 3),
                    randomString(i * 3)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("myGroupProvider")
    public void canCreateMyMultipleGroup(GroupData my_group) {
        int myGroupCount = my_app.my_groups().getMyGroupsCount();
        my_app.my_groups().createMyGroup(my_group);
        int myNewGroupCount = my_app.my_groups().getMyGroupsCount();
        Assertions.assertEquals(myGroupCount + 1, myNewGroupCount);
    }
}
