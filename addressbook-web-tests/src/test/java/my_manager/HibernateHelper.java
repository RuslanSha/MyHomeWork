package my_manager;

import my_manager.hbm.ContactRecord;
import my_manager.hbm.GroupInContact;
import my_manager.hbm.GroupRecord;
import my_model.ContactData;
import my_model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {
    private final SessionFactory sessionFactory;
    private static String jdbcMysqlUrl;
    private static String jdbcMysqlUsername;
    private static String jdbcMysqlPassword;

    public HibernateHelper(ApplicationManager my_manager) {
        super(my_manager);
        jdbcMysqlUrl = my_manager.my_properties().getProperty("db.baseUrl");
        jdbcMysqlUsername = my_manager.my_properties().getProperty("db.username");
        jdbcMysqlPassword = my_manager.my_properties().getProperty("db.password");

        sessionFactory = new Configuration()
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .addAnnotatedClass(GroupInContact.class)
                .setProperty(AvailableSettings.URL, jdbcMysqlUrl)
                .setProperty(AvailableSettings.USER, jdbcMysqlUsername)
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, jdbcMysqlPassword)
                .buildSessionFactory();
    }

    public void createMyContact(ContactData my_contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(my_contactData));
            session.getTransaction().commit();
        });
    }

    public void createMyGroup(GroupData my_groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(my_groupData));
            session.getTransaction().commit();
        });
    }

    public void addGroupToContact(ContactData my_contactdata, GroupData my_groupdata) {
        sessionFactory.inSession(session -> {
            var newGroupInContact = new GroupInContact(Integer.parseInt(my_contactdata.my_id()),
                    Integer.parseInt(my_groupdata.my_id()));
            session.getTransaction().begin();
            session.persist(newGroupInContact);
            session.getTransaction().commit();
        });
    }

    public long getMyContactsCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public long getMyGroupsCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public List<ContactData> getMyContactList() {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.createQuery("from ContactRecord", ContactRecord.class).list());
        });
    }

    public List<GroupData> getMyGroupList() {
        return sessionFactory.fromSession(session -> {
            return convertGroupList(session.createQuery("from GroupRecord", GroupRecord.class).list());
        });
    }

    public List<ContactData> getMyContactsInGroup(GroupData my_group) {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, my_group.my_id()).my_contacts);
        });
    }

    public long getMyGroupsInContactCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupInContact", Long.class).getSingleResult();
        });
    }

    public List<GroupData> getMyGroupsInContact() {
        return sessionFactory.fromSession(session -> {
            var my_contacts = getMyContactList();
            List<GroupRecord> result = new ArrayList<>();
            for (var my_contact : my_contacts) {
                result.addAll(session.get(ContactRecord.class, my_contact.my_id()).my_groups);
            }
            return convertGroupList(result);
        });
    }

    static List<ContactData> convertContactList(List<ContactRecord> my_records) {
        List<ContactData> result = new ArrayList<>();
        for (var my_record : my_records) {
            result.add(convert(my_record));
        }
        return result;
    }

    static List<GroupData> convertGroupList(List<GroupRecord> my_records) {
        List<GroupData> result = new ArrayList<>();
        for (var my_record : my_records) {
            result.add(convert(my_record));
        }
        return result;
    }

    private static ContactData convert(ContactRecord my_record) {
        return new ContactData().withId("" + my_record.my_id)
                .withFirstname(my_record.my_firstname)
                .withMiddlename(my_record.my_middlename)
                .withLastname(my_record.my_lastname)
                .withNickname(my_record.my_nickname)
                .withTitle(my_record.my_title)
                .withCompany(my_record.my_company)
                .withAddress(my_record.my_address)
                .withMobile(my_record.my_mobile)
                .withEmail(my_record.my_email)
                .withPhoto(my_record.my_photo);
    }

    private static ContactRecord convert(ContactData my_data) {
        var my_id = my_data.my_id();
        if ("".equals(my_id)) {
            my_id = "0";
        }
        return new ContactRecord(Integer.parseInt(my_id),
                my_data.my_firstname(),
                my_data.my_middlename(),
                my_data.my_lastname(),
                my_data.my_nickname(),
                my_data.my_title(),
                my_data.my_company(),
                my_data.my_address(),
                my_data.my_mobile(),
                my_data.my_email(),
                my_data.my_photo());
    }

    private static GroupData convert(GroupRecord my_record) {
        return new GroupData("" + my_record.my_id,
                my_record.my_name,
                my_record.my_header,
                my_record.my_footer);
    }

    private static GroupRecord convert(GroupData my_data) {
        var my_id = my_data.my_id();
        if ("".equals(my_id)) {
            my_id = "0";
        }
        return new GroupRecord(Integer.parseInt(my_id),
                my_data.my_name(),
                my_data.my_header(),
                my_data.my_footer());
    }
}
