package my_tests;

import my_model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyGroupCreationTests extends TestBase {

    public static List<GroupData> myGroupProvider() {
        var result = new ArrayList<GroupData>();
        for (int i = 2; i < 5; i++) {
            result.add(new GroupData("",
                    randomString(i * 3),
                    randomString(i * 3),
                    randomString(i * 3)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("myGroupProvider")
    public void canCreateMyMultipleGroup(GroupData my_group) {
        var myOldGroups = my_app.my_groups().getMyGroupList();
        my_app.my_groups().createMyGroup(my_group);
        var myNewGroups = my_app.my_groups().getMyGroupList();
        Comparator<GroupData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.my_id()), Integer.parseInt(o2.my_id()));
        };
        myNewGroups.sort(compareById);
        var myExpectedList = new ArrayList<>(myOldGroups);
        myExpectedList.add(my_group.withId(myNewGroups.get(myNewGroups.size() - 1).my_id())
                .withHeader("")
                .withFooter(""));
        myExpectedList.sort(compareById);
        Assertions.assertEquals(myNewGroups, myExpectedList);
    }
}
