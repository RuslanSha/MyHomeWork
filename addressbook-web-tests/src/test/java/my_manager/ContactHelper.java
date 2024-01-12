package my_manager;

import my_model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

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

    public void removeMyContact(ContactData my_contact) {
        openMyContactsPage();
        selectMyContact(my_contact);
        removeMySelectedContact();
        try {
            my_manager.my_driver.switchTo().alert().accept();
        } catch (Exception e) {
//            OK for any errors
        }
        returnToMyHomePage();
    }

    public int getMyContactsCount() {
        openMyContactsPage();
        return my_manager.my_driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getMyContactList() {
        openMyContactsPage();
        var my_contacts = new ArrayList<ContactData>();
        var my_checkboxes = my_manager.my_driver.findElements(
                By.xpath("//input[@type=\'checkbox\'][@name=\'selected[]\']"));
        for (var my_checkbox : my_checkboxes) {
            var my_id = my_checkbox.getAttribute("value");
            var my_email = my_checkbox.getAttribute("accept");
            my_contacts.add(new ContactData().withId(my_id).withEmail(my_email));
        }
        return my_contacts;
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

    private void selectMyContact(ContactData my_contact) {
        click(By.cssSelector(String.format("input[value='%s']", my_contact.my_id())));
    }

    private void removeMySelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
    }

    private void returnToMyContactsPage() {
        click(By.linkText("home page"));
    }

    private void returnToMyHomePage() {
        click(By.linkText("home"));
    }
}
