import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyGroupCreationTests {
    private WebDriver driver;

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

    @Test
    public void canCreateMyGroup() {
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("my_group_name");
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys("my_group_header");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys("my_group_footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
