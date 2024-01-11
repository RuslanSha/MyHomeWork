package my_tests;

import my_manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {
    protected static ApplicationManager my_app;

    @BeforeEach
    public void setUp() {
        if (my_app == null) {
            my_app = new ApplicationManager();
        }
        my_app.init(System.getProperty("browser", "firefox"));
    }

    @AfterEach
    public void tearDown() {
        my_app.my_session().close();
    }

    public static String randomString(int length) {
        var my_rnd = new Random();
        var my_result = "";
        for (int i = 0; i < length; i++) {
            my_result += (char) ('a' + my_rnd.nextInt(26));
        }
        return my_result;
    }

    public static String randomNumber(int length) {
        var my_rnd = new Random();
        var my_result = "";
        for (int i = 0; i < length; i++) {
            my_result += (char) ('0' + my_rnd.nextInt(9));
        }
        return my_result;
    }
}
