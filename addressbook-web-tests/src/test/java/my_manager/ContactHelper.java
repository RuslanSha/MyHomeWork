package my_manager;

import my_model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager my_manager) {
        super(my_manager);
    }

    public void createMyContact(ContactData my_contact) {
        openMyContactsPage();
        initMyContactCreation();
        fillMyContactForm(my_contact);
        submitMyContactCreation();
        returnToMyContactsPage();
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

    public int getMyContactsCount() {
        openMyContactsPage();
        return my_manager.my_driver.findElements(By.name("selected[]")).size();
    }

    public void openMyContactsPage() {
        click(By.linkText("home"));
    }

    private void initMyContactCreation() {
        click(By.linkText("add new"));
    }

    private void fillMyContactForm(ContactData my_contact) {
        type(By.name("firstname"), my_contact.my_firstname());
        type(By.name("middlename"), my_contact.my_middlename());
        type(By.name("lastname"), my_contact.my_lastname());
        type(By.name("nickname"), my_contact.my_nickname());
        type(By.name("title"), my_contact.my_title());
        type(By.name("company"), my_contact.my_company());
        type(By.name("address"), my_contact.my_address());
        type(By.name("mobile"), my_contact.my_mobile());
        type(By.name("email"), my_contact.my_email());
    }

    private void submitMyContactCreation() {
        click(By.name("submit"));
    }

    private void returnToMyContactsPage() {
        click(By.linkText("home page"));
    }
}
