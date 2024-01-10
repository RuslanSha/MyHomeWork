import org.junit.jupiter.api.Test;

public class MyGroupRemovalTests extends TestBase {

    @Test
    public void canRemoveMyGroup() {
        openMyGroupsPage();
        if (!isMyGroupPresent()) {
            createMyGroup();
        }
        removeMyGroup();
    }
}
