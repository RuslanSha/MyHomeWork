package my_manager;

import org.openqa.selenium.By;

public class HelperBase {
    protected final ApplicationManager my_manager;

    public HelperBase(ApplicationManager my_manager) {
        this.my_manager = my_manager;
    }

    protected void click(By my_locator) {
        my_manager.my_driver.findElement(my_locator).click();
    }

    protected void type(By my_locator, String my_group_header) {
        click(my_locator);
        my_manager.my_driver.findElement(my_locator).sendKeys(my_group_header);
    }

    protected void quit() {
        my_manager.my_driver.quit();
    }
}
