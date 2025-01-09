package view;

import model.NumberList;

import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;
    private NumberList numberList;

    public UserInput( ) {
        this.scanner = new Scanner(System.in);
        this.numberList = NumberList.getInstance();
    }

    public void getNumbers(){
        while (scanner.hasNextLong()){
            numberList.addNumber(scanner.nextInt());
        }
    }
}
