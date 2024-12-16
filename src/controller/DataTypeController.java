package controller;

import view.PrintMessage;
import view.UserInput;

import static controller.DataTypeArgument.dataTypeArgumentChoice;

public class DataTypeController {
    DataTypeArgument dataTypeArgument;
    UserInput userInput;
    PrintMessage printMessage;

    public DataTypeController(){
        userInput = new UserInput();
        printMessage = new PrintMessage();

        dataTypeArgument = new DataTypeArgument();
        dataTypeControl();
    }

    private void dataTypeControl(){
        switch (dataTypeArgumentChoice){
            case "line":
                userInput.getLines();
                printMessage.printOutputForLines();
                break;
            case "word":
                userInput.getWords();
                printMessage.printOutputForWords();
                break;
            case "long":
                userInput.getNumbers();
                printMessage.printOutputForNumbers();
                break;
        }
    }
}
