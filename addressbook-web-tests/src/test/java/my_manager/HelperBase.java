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

    protected void type(By my_locator, String text) {
        click(my_locator);
        my_manager.my_driver.findElement(my_locator).sendKeys(text);
    }

    protected void quit() {
        my_manager.my_driver.quit();
    }
}
