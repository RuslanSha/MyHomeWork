package my_manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager my_manager) {
        super(my_manager);
    }

    public void createMyContact() {
        click(By.linkText("add new"));
        type(By.name("firstname"), "my_firstname");
        type(By.name("middlename"), "my_middlename");
        type(By.name("lastname"), "my_lastname");
        type(By.name("nickname"), "my_nickname");
        type(By.name("title"), "my_title");
        type(By.name("company"), "my_company");
        type(By.name("address"), "my_address");
        type(By.name("mobile"), "85557776611");
        type(By.name("email"), "my_email@my_domain");
        click(By.name("submit"));
        click(By.linkText("home page"));
    }

    public void removeMyContact() {
        click(By.name("selected[]"));
        click(By.xpath("//input[@value=\'Delete\']"));
        try {
            my_manager.my_driver.switchTo().alert().accept();
        } catch (Exception e) {
//            OK for any errors
        }
        click(By.linkText("home"));
    }

    public void openMyContactsPage() {
        click(By.linkText("home"));
    }

    public boolean isMyContactPresent() {
        return my_manager.isElementPresent(By.name("selected[]"));
    }
}
