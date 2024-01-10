package my_tests;

import my_manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected static ApplicationManager my_app;

    @BeforeEach
    public void setUp() {
        if (my_app == null) {
            my_app = new ApplicationManager();
        }
        my_app.init(System.getProperty("browser","firefox"));
    }

    @AfterEach
    public void tearDown() {
        my_app.my_session().close();
    }
}
