import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:81/addressbook/");
        driver.manage().window().setSize(new Dimension(1150, 790));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    protected boolean isElementPresent(By myLocator) {
        try {
            driver.findElement(myLocator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
