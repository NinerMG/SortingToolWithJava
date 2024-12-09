package view;

import model.NumberList;

import java.util.Scanner;

public class UserInput {
    NumberList list;

    public UserInput(){
        list = NumberList.getInstance();
    }

    public void getNumbers(){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLong()){
                list.addNumber(scanner.nextLong());
        }
    }
}
