package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class DataBase {
    private final String userName;
    private String birthDate;
    private char gender;
    private long pn;
    private String fileName;



    public DataBase(String userName, String birthDate, char gender, long pn) {
        this.gender = gender;
        this.userName = userName;
        this.pn = pn;
        this.birthDate = birthDate;
        String el = Collections.singletonList(userName.split(" ")[0]).toString();
        this.fileName = el.substring(1,el.length()-1) + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)){
            writer.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveToFile(){
        StringBuilder sb = new StringBuilder(userName + pn + " " + birthDate + " " + gender);
       try(FileWriter writer = new FileWriter(fileName, true)) {
           writer.write(String.valueOf(sb) + "\n");
           writer.flush();
       }catch (IOException e){
           System.out.println(e.getMessage());
       }
    }
}
