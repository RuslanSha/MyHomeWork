import my_tests.TestBase;
import org.junit.jupiter.api.Test;

public class MyGroupRemovalTests extends TestBase {

    @Test
    public void canRemoveMyGroup() {
        app.openMyGroupsPage();
        if (!app.isMyGroupPresent()) {
            app.createMyGroup();
        }
        app.removeMyGroup();
    }
}
