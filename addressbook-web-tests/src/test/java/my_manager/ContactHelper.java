package my_manager;

import my_model.ContactData;
import my_model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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
        submitMyContact();
        returnToMyContactsPage();
    }

    public void createMyContact(ContactData my_contact, GroupData my_group) {
        openMyContactsPage();
        initMyContactCreation();
        fillMyContactForm(my_contact);
        selectMyGroup(my_group);
        submitMyContact();
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

    public void modifyMyContact(ContactData my_contact, ContactData my_modifiedContact) {
        openMyContactsPage();
        selectMyContact(my_contact);
        initMyContactModification(my_contact);
        fillMyContactName(my_modifiedContact);
        updateMyContact();
        returnToMyHomePage();
    }

    public void modifyMyContact(ContactData my_contact, GroupData my_group) {
        openMyContactsPage();
        selectMyContact(my_contact);
        selectMyNewGroup(my_group);
        addMyContact();
        returnToMyHomePage();
    }

    public void removeGroupFromMyContact(ContactData my_contact, GroupData my_group) {
        openMyContactsPage();
        selectMyContactByGroup(my_group);
        selectMyContact(my_contact);
        removeMyContact();
        returnToMyHomePage();
    }

    public int getMyContactsCount() {
        openMyContactsPage();
        return my_manager.my_driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getMyContactList() {
        openMyContactsPage();
        var my_contacts = new ArrayList<ContactData>();
        var my_table = my_manager.my_driver.findElements(
                By.cssSelector("table[id='maintable']>tbody>tr[name='entry']"));
        for (var my_element : my_table) {
            var my_id = my_element.findElement(By.cssSelector("td.center>input"))
                    .getAttribute("value");
            var my_lastname = my_element.findElement(By.cssSelector("td:nth-child(2)"))
                    .getText();
            var my_firstname = my_element.findElement(By.cssSelector("td:nth-child(3)"))
                    .getText();
            my_contacts.add(new ContactData()
                    .withId(my_id)
                    .withFirstname(my_firstname)
                    .withLastname(my_lastname));
        }
        return my_contacts;
    }

    public void openMyContactsPage() {
        click(By.linkText("home"));
    }

    private void initMyContactCreation() {
        click(By.linkText("add new"));
    }

    private void initMyContactModification(ContactData my_contact) {
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", my_contact.my_id())));
    }

    private void fillMyContactForm(ContactData my_contact) {
        type(By.name("firstname"), my_contact.my_firstname());
        type(By.name("middlename"), my_contact.my_middlename());
        type(By.name("lastname"), my_contact.my_lastname());
        type(By.name("nickname"), my_contact.my_nickname());
        attach(By.name("photo"), my_contact.my_photo());
        type(By.name("title"), my_contact.my_title());
        type(By.name("company"), my_contact.my_company());
        type(By.name("address"), my_contact.my_address());
        type(By.name("mobile"), my_contact.my_mobile());
        type(By.name("email"), my_contact.my_email());
    }

    private void fillMyContactName(ContactData my_contact) {
        type(By.name("firstname"), my_contact.my_firstname());
        type(By.name("lastname"), my_contact.my_lastname());
    }

    private void selectMyGroup(GroupData my_group) {
        new Select(my_manager.my_driver.findElement(By.name("new_group"))).selectByValue(my_group.my_id());
    }

    private void selectMyNewGroup(GroupData my_group) {
        click(By.name("to_group"), By.cssSelector(String.format("option[value='%s']", my_group.my_id())));
    }

    private void selectMyContactByGroup(GroupData my_group) {
        click(By.name("group"), By.cssSelector(String.format("option[value='%s']", my_group.my_id())));
    }

    private void submitMyContact() {
        click(By.name("submit"));
    }

    private void addMyContact() {
        click(By.name("add"));
    }

    private void updateMyContact() {
        click(By.name("update"));
    }

    private void removeMyContact() {
        click(By.name("remove"));
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
