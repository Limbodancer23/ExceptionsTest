package Controller;

import ExceptionBlock.Exceptions.*;

import java.util.Arrays;

public class ExceptionLogic {
    Parser parser;

    public ExceptionLogic(Parser parser) {
    this.parser = parser;
    }

    private void dataMismatch(){
        int code = 420;
        String userData = parser.getUserData();
        int count = (int) Arrays.stream(userData.split(" ")).filter(el -> !el.equals("")).count();
        if (count != 6) {
            System.out.println("Wrong number of data elements");
            System.exit(code);
        }

    }

    private void nameCheck() {
        String name = parser.getUserName();
        try {
            for (String str : name.split(" ")) {
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (Character.isDigit(c)){
                        throw new UserDataException(str);
                    }
                }
                if (str.matches("[0-9]+")) throw new UserDataException(str);
                if (Arrays.asList(name.split(" ")).size() != 3) throw new NameSizeException(name);
            }
        }catch (UserDataException | NameSizeException e){
            System.out.println(e.getMessage());
            System.exit(420);
        }
    }


    private void birthDayCheck() {
        String birthday = parser.getBirthDate();
        try {
            if (birthday.equals("0")){
                throw new BirthDayException(birthday);
            }
        }catch (BirthDayException e){
            System.out.println(e.getMessage());
            System.exit(420);
        }
    }


    private void genderCheck() {
        char gender = parser.getGender();
        try {
            if (gender != 'f' & gender != 'm') throw new GenderArgumentException(gender);
        }catch (GenderArgumentException e){
            System.out.println(e.getMessage());
            System.exit(420);
        }
    }

    private void phoneNumberCheck() {
        try {
            long pn = parser.getPhoneNumber();
            if (pn == 0)throw new PhoneNumberFormatException(pn);
        }catch (PhoneNumberFormatException e){
            System.out.println(e.getMessage());
            System.exit(420);
        }
    }

    public void testData(){
        dataMismatch();
        phoneNumberCheck();
        genderCheck();
        birthDayCheck();
        nameCheck();
    }
}
