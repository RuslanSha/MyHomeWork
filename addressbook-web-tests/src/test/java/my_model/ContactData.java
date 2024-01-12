package my_model;

public record ContactData(String my_id,
                          String my_firstname,
                          String my_middlename,
                          String my_lastname,
                          String my_nickname,
                          String my_title,
                          String my_company,
                          String my_address,
                          String my_mobile,
                          String my_email) {

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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                this.my_email);
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
                my_email);
    }
}
