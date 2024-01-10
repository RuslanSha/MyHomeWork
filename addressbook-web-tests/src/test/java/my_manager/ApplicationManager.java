package my_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
    protected WebDriver my_driver;
    public LoginHelper my_session;
    private GroupHelper my_groups;
    private ContactHelper my_contacts;

    public void init() {
        my_driver = new FirefoxDriver();
        my_driver.get("http://localhost:81/addressbook/");
        my_driver.manage().window().setSize(new Dimension(1150, 790));
        my_session().login("admin", "secret");
    }

    public LoginHelper my_session() {
        if (my_session == null) {
            my_session = new LoginHelper(this);
        }
        return my_session;
    }

    public GroupHelper my_groups() {
        if (my_groups == null) {
            my_groups = new GroupHelper(this);
        }
        return my_groups;
    }

    public ContactHelper my_contacts() {
        if (my_contacts == null) {
            my_contacts = new ContactHelper(this);
        }
        return my_contacts;
    }

    protected boolean isElementPresent(By myLocator) {
        try {
            my_driver.findElement(myLocator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
