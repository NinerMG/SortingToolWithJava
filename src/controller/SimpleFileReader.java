package controller;

import model.GenericList;
import view.UserInput;

import java.io.*;
import java.util.Scanner;

public class SimpleFileReader {

    private  String filePath = "resources/input.txt";
    private GenericList<Object> genericList;
    private Scanner scanner;
    private UserInput userInput;

    public SimpleFileReader(){
        genericList = GenericList.getInstance();
        userInput = new UserInput();
    }

    public  void readingFile(String dataType){
        try {
            scanner = new Scanner(new File(filePath));

            if("numbers".equals(dataType)){
                userInput.readNumbers(scanner);
            } else if ("lines".equals(dataType)){
                userInput.readLines(scanner);
            } else if ("words".equals(dataType)){
                userInput.readWords(scanner);
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found: " + filePath);
        }
    }
}
