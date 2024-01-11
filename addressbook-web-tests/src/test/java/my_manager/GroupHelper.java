package my_manager;

import my_model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {
    public GroupHelper(ApplicationManager my_manager) {
        super(my_manager);
    }

    public void createMyGroup(GroupData my_group) {
        openMyGroupsPage();
        initMyGroupCreation();
        fillMyGroupForm(my_group);
        submitMyGroupCreation();
        returnToMyGroupsPage();
    }

    public void removeMyGroup() {
        openMyGroupsPage();
        selectMyGroup();
        removeMySelectedGroup();
        returnToMyGroupsPage();
    }

    public void openMyGroupsPage() {
        if (!my_manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isMyGroupPresent() {
        return my_manager.isElementPresent(By.name("selected[]"));
    }

    private void initMyGroupCreation() {
        click(By.name("new"));
    }

    private void fillMyGroupForm(GroupData my_group) {
        type(By.name("group_name"), my_group.my_name());
        type(By.name("group_header"), my_group.my_header());
        type(By.name("group_footer"), my_group.my_footer());
    }

    private void submitMyGroupCreation() {
        click(By.name("submit"));
    }

    private void returnToMyGroupsPage() {
        click(By.linkText("group page"));
    }

    private void selectMyGroup() {
        click(By.name("selected[]"));
    }

    private void removeMySelectedGroup() {
        click(By.name("delete"));
    }
}
