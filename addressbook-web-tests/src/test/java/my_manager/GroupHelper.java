package my_manager;

import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager my_manager) {
        super(my_manager);
    }

    public void createMyGroup() {
        click(By.name("new"));
        type(By.name("group_name"), "my_group_name");
        type(By.name("group_header"), "my_group_header");
        type(By.name("group_footer"), "my_group_footer");
        click(By.name("submit"));
        click(By.linkText("group page"));
    }

    public void removeMyGroup() {
        click(By.name("selected[]"));
        click(By.name("delete"));
        click(By.linkText("group page"));
    }

    public void openMyGroupsPage() {
        click(By.linkText("groups"));
    }

    public boolean isMyGroupPresent() {
        return my_manager.isElementPresent(By.name("selected[]"));
    }
}
