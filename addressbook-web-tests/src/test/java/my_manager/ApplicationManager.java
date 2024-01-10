package my_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected static WebDriver driver;

    public void init() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.get("http://localhost:81/addressbook/");
            driver.manage().window().setSize(new Dimension(1150, 790));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
        }
    }

    public void close() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
        driver = null;
    }

    protected boolean isElementPresent(By myLocator) {
        try {
            driver.findElement(myLocator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void createMyGroup() {
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

    public void openMyGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public boolean isMyGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void removeMyGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
