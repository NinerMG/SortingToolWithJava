package view;

import model.NumberList;

public class PrintMessage {
    NumberList list;

    public PrintMessage(){
        list = NumberList.getInstance();
    }

    public void printOutput(){
        System.out.printf("Total numbers: %d.",
                list.maximumValue());
        System.out.println();
        System.out.printf("The greatest number: %d (%d time(s))%n",
                list.maximumValue(),
                list.getFrequency(list.maximumValue()));
    }

}
