package my_tests;

import my_model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class MyContactRemovalTests extends TestBase {

    @Test
    public void canRemoveMyContact() {
        if (my_app.my_contacts().getMyContactsCount() == 0) {
            my_app.my_contacts().createMyContact(new ContactData("",
                    "my_firstname",
                    "my_middlename",
                    "my_lastname",
                    "my_nickname",
                    "my_title",
                    "my_company",
                    "my_address",
                    "81236669977",
                    "my_email@my_domain",
                    my_app.my_properties().getProperty("file.photoDir") + "/avatar.png"));
        }
        var myOldContacts = my_app.my_contacts().getMyContactList();
        var my_rnd = new Random();
        var my_index = my_rnd.nextInt(myOldContacts.size());
        my_app.my_contacts().removeMyContact(myOldContacts.get(my_index));
        var myNewContacts = my_app.my_contacts().getMyContactList();
        var myExpectedList = new ArrayList<>(myOldContacts);
        myExpectedList.remove(my_index);
        Assertions.assertEquals(myNewContacts, myExpectedList);
    }
}
