package my_tests;

import my_common.MyCommonFunctions;
import my_model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class MyContactModificationTests extends TestBase {

    @Test
    void canModifyMyContact() {
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
                    "src/test/resources/images/avatar.png"));
        }
        var myOldContacts = my_app.my_contacts().getMyContactList();
        var my_rnd = new Random();
        var my_index = my_rnd.nextInt(myOldContacts.size());
        var myTestData = new ContactData()
                .withFirstname(String.format("mod_fn_%s+%s",
                        MyCommonFunctions.randomString(3),
                        MyCommonFunctions.randomNumber(2)))
                .withLastname(String.format("mod_ln_%s+%s",
                        MyCommonFunctions.randomString(3),
                        MyCommonFunctions.randomNumber(2)));
        my_app.my_contacts().modifyMyContact(myOldContacts.get(my_index), myTestData);
        var myNewContacts = my_app.my_contacts().getMyContactList();
        var myExpectedList = new ArrayList<>(myOldContacts);
        myExpectedList.set(my_index, myTestData.withId(myOldContacts.get(my_index).my_id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.my_id()), Integer.parseInt(o2.my_id()));
        };
        myNewContacts.sort(compareById);
        myExpectedList.sort(compareById);
        Assertions.assertEquals(myNewContacts, myExpectedList);
    }
}
