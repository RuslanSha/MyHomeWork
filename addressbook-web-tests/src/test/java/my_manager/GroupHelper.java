package my_manager;

import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager my_manager;

    public GroupHelper(ApplicationManager my_manager) {
        this.my_manager = my_manager;
    }

    public void openMyGroupsPage() {
        my_manager.my_driver.findElement(By.linkText("groups")).click();
    }

    public boolean isMyGroupPresent() {
        return my_manager.isElementPresent(By.name("selected[]"));
    }

    public void removeMyGroup() {
        my_manager.my_driver.findElement(By.name("selected[]")).click();
        my_manager.my_driver.findElement(By.name("delete")).click();
        my_manager.my_driver.findElement(By.linkText("group page")).click();
    }

    public void createMyGroup() {
        my_manager.my_driver.findElement(By.name("new")).click();
        my_manager.my_driver.findElement(By.name("group_name")).click();
        my_manager.my_driver.findElement(By.name("group_name")).sendKeys("my_group_name");
        my_manager.my_driver.findElement(By.name("group_header")).click();
        my_manager.my_driver.findElement(By.name("group_header")).sendKeys("my_group_header");
        my_manager.my_driver.findElement(By.name("group_footer")).click();
        my_manager.my_driver.findElement(By.name("group_footer")).sendKeys("my_group_footer");
        my_manager.my_driver.findElement(By.name("submit")).click();
        my_manager.my_driver.findElement(By.linkText("group page")).click();
    }
}
