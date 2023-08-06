package UserView;

import Controller.ExceptionLogic;
import Controller.Parser;
import Model.DataBase;

import java.util.Scanner;

public class View {
    ExceptionLogic logic;
    Parser parser;
    public View(Parser parser, ExceptionLogic logic) {
        this.parser = parser;
        this.logic = logic;
    }

    public void start(){
        String userData = promt("Enter your Lastname Firstname Surname, birth date(dd.mm.yyyy), phone number and gender(m/f)\nSeparate data`s with spaces: ");
        parser.tryToParse(userData);
        logic.testData();
        DataBase dataBase = new DataBase(parser.getUserName(), parser.getBirthDate(), parser.getGender(), parser.getPhoneNumber());
        dataBase.saveToFile();

    }

    private String promt(String message){
        Scanner scan = new Scanner(System.in);
        System.out.println(message);
        return scan.nextLine();
    }
}
