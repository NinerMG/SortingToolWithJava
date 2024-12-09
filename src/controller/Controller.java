package controller;

import model.NumberList;
import view.PrintMessage;
import view.UserInput;

public class Controller {
    UserInput userInput;
    NumberList numberList;
    PrintMessage printMessage;

    public Controller(){
        userInput = new UserInput();
        numberList = NumberList.getInstance();
        printMessage = new PrintMessage();

        userInput.getNumbers();
        printMessage.printOutput();
    }
}
