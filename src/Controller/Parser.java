package Controller;

public class Parser {

    private String userData;
    private String userName = "";
    private char gender = '0';
    private String birthDate = "0";
    private long phoneNumber = 0;


    public Parser() {;
    }

    public void tryToParse(String userData){
        this.userData = userData;
        for (String str : userData.split(" ")) {
            if (str.matches("[/A-z]+") & str.length() > 1) {
                userName += str + " ";
            }
            if (str.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-.](0?[1-9]|1[012])[\\/\\-.]\\d{4}$")) birthDate = str;
            if (str.length() == 1) gender = str.charAt(0);
            else if (str.matches("[0-9]+"))
                phoneNumber = Long.parseLong(str);

        }
    }

    public char getGender() {
        return gender;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getUserData() {
        return userData;
    }

    public String getUserName() {
        return userName;
    }
}
