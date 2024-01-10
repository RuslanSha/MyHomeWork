import org.junit.jupiter.api.Test;

public class MyGroupCreationTests extends TestBase {

    @Test
    public void canCreateMyGroup() {
        openMyGroupsPage();
        createMyGroup();
    }
}
