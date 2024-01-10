import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MyGroupCreationTests extends TestBase {

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
