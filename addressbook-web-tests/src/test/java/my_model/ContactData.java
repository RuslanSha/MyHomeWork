package my_model;

import my_common.MyCommonFunctions;

public record ContactData(String my_id,
                          String my_firstname,
                          String my_middlename,
                          String my_lastname,
                          String my_nickname,
                          String my_title,
                          String my_company,
                          String my_address,
                          String my_mobile,
                          String my_email,
                          String my_photo) {

    public ContactData() {
        this("",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "");
    }

    public ContactData withId(String my_id) {
        return new ContactData(my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withFirstname(String my_firstname) {
        return new ContactData(this.my_id,
                my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withMiddlename(String my_middlename) {
        return new ContactData(this.my_id,
                this.my_firstname,
                my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withLastname(String my_lastname) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withNickname(String my_nickname) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withTitle(String my_title) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withCompany(String my_company) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withAddress(String my_address) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                my_address,
                this.my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withMobile(String my_mobile) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                my_mobile,
                this.my_email,
                this.my_photo);
    }

    public ContactData withEmail(String my_email) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                my_email,
                this.my_photo);
    }

    public ContactData withPhoto(String my_photo) {
        return new ContactData(this.my_id,
                this.my_firstname,
                this.my_middlename,
                this.my_lastname,
                this.my_nickname,
                this.my_title,
                this.my_company,
                this.my_address,
                this.my_mobile,
                this.my_email,
                my_photo);
    }

    public ContactData withRandomData(int my_salt, String my_photo_dir) {
        return new ContactData(this.my_id,
                MyCommonFunctions.randomString(my_salt * 2),
                MyCommonFunctions.randomString(my_salt * 2),
                MyCommonFunctions.randomString(my_salt * 3),
                MyCommonFunctions.randomString(my_salt * 2),
                MyCommonFunctions.randomString(my_salt * 2),
                MyCommonFunctions.randomString(my_salt * 4),
                MyCommonFunctions.randomString(my_salt * 5),
                MyCommonFunctions.randomNumber(11),
                String.format("%s@%s.info",
                        MyCommonFunctions.randomString(my_salt * 2),
                        MyCommonFunctions.randomString(my_salt * 2)),
                MyCommonFunctions.randomFile(my_photo_dir));
    }
}
