import my_tests.TestBase;
import org.junit.jupiter.api.Test;

public class MyGroupCreationTests extends TestBase {

    @Test
    public void canCreateMyGroup() {
        app.openMyGroupsPage();
        app.createMyGroup();
    }
}
