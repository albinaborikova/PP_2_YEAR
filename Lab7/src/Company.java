import java.io.IOException;
import java.util.Arrays;

public class Company {
    private String name;
    private String shortTitle; ///Important
    private String dateUpdate;
    private String address;
    private String dateFoundation; ///Important
    private String countEmployees; ///Important
    private String auditor;
    private String phone;
    private String email;
    private String branch; ///Important
    private String activity; ///Important
    private String link;

    public String getName() {
        return name;
    }
    public String getShortTitle() {
        return shortTitle;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public String getAddress() {
        return address;
    }

    public String getDateFoundation() {
        return dateFoundation;
    }

    public String getCountEmployees() {
        return countEmployees;
    }

    public String getAuditor() {
        return auditor;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBranch() {
        return branch;
    }

    public String getActivity() {
        return activity;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateFoundation(String dateFoundation) {
        this.dateFoundation = dateFoundation;
    }

    public void setCountEmployees(String countEmployees) {
        this.countEmployees = countEmployees;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public String toJSONString() {
        return "\"Company\": \n{ \n" +
                "\"name\":\"" + name + "\" \n" +
                "\" shortTitle\":\"" + shortTitle + "\" \n" +
                " \"dateUpdate\":\"" + dateUpdate + "\" \n" +
                " \"address\":\"" + address + "\" \n" +
                " \"dateFoundation\":\"" + dateFoundation + "\"\n" +
                " \"countEmployees\":\"" + countEmployees + "\"\n" +
                " \"auditor\":\"" + auditor + "\"\n" +
                " \"phone\":\"" + phone + "\"\n" +
                " \"email\":\"" + email + "\"\n" +
                " \"branch\":\"" + branch + "\"\n" +
                " \"activity\":\"" + activity + "\"\n" +
                " \"link\":\"" + link + "\" \n" +
                "}";
    }
    public String toXMLString() {
        return "<Company> \n" +
                "<name>" + name + "</name> \n" +
                "<shortTitle>" + shortTitle + "</shortTitle> \n" +
                "<dateUpdate>" + dateUpdate + "</dateUpdate> \n" +
                "<address>" + address + "/<address> \n" +
                "<dateFoundation>" + dateFoundation + " </dateFoundation> \n" +
                "<countEmployees>" + countEmployees + "</countEmployees> \n" +
                "<auditor>" + auditor + "</auditor> \n" +
                "<phone>" + auditor + "</phone> \n" +
                "<email>" + auditor + "</email> \n" +
                "<branch>" + auditor + "</branch> \n" +
                "<activity>" + auditor + "</activity> \n" +
                "<link>" + auditor + "</link> \n" +
                "</Company>";
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", shortTitle='" + shortTitle + '\'' +
                ", dateUpdate='" + dateUpdate + '\'' +
                ", address='" + address + '\'' +
                ", dateFoundation='" + dateFoundation + '\'' +
                ", countEmployees='" + countEmployees + '\'' +
                ", auditor='" + auditor + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", branch='" + branch + '\'' +
                ", activity='" + activity + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public Company(String name, String shortTitle, String dateUpdate, String address, String dateFoundation, String countEmployees, String auditor, String phone, String email, String branch, String activity, String link) {
        this.name = name;
        this.shortTitle = shortTitle;
        this.dateUpdate = dateUpdate;
        this.address = address;
        this.dateFoundation = dateFoundation;
        this.countEmployees = countEmployees;
        this.auditor = auditor;
        this.phone = phone;
        this.email = email;
        this.branch = branch;
        this.activity = activity;
        this.link = link;
    }

    public  Company (String INPUT)
    {
        String[] str = INPUT.split(";");
//        System.out.println(str.length);
//        for (int i = 0; i < str.length; i++)
//            System.out.println(str[i]);
        this.name = str[0];
        this.shortTitle = str[1];
        this.dateUpdate = str[2];
        this.address = str[3];
        this.dateFoundation = str[4];
        this.countEmployees = str[5];
        this.auditor = str[6];
        this.phone = str[7];
        this.email = str[8];
        this.branch = str[9];
        this.activity = str[10];
        this.link = str[11];
    }


}
