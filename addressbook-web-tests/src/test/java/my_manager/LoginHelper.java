package my_manager;

import org.openqa.selenium.By;

public class LoginHelper {
    private final ApplicationManager my_manager;

    public LoginHelper(ApplicationManager my_manager) {
        this.my_manager = my_manager;
    }
    public void login(String my_user, String my_password) {
        my_manager.my_driver.findElement(By.name("user")).sendKeys(my_user);
        my_manager.my_driver.findElement(By.name("pass")).sendKeys(my_password);
        my_manager.my_driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }

    public void close() {
        my_manager.my_driver.findElement(By.linkText("Logout")).click();
        my_manager.my_driver.quit();
    }
}
