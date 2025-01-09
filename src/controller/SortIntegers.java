package controller;

import model.NumberList;
import view.PrintOutput;
import view.UserInput;

import java.util.ArrayList;

public class SortIntegers {
    UserInput userInput;
    NumberList numberList;
    SortingTool sortingTool;
    PrintOutput printOutput;

    public SortIntegers(){
        userInput = new UserInput();
        numberList = NumberList.getInstance();
        sortingTool = new SortingTool();
        printOutput = new PrintOutput();

        start();
    }

    private void start(){
        userInput.getNumbers();

        System.out.println("Your unsorted list: ");
        numberList.printElements();

        System.out.println("Total numbers: " + numberList.listSize() + ".");


        sortingMessage();

    }

    private void sortingMessage() {
        ArrayList<Integer> toSort = new ArrayList<>(numberList.getList());
        System.out.println("Sorted data:");
        System.out.println("Stream Sort:");
        printOutput.printListElements(sortingTool.streamSort(toSort));
        System.out.println();
        System.out.println("Comparator Sort:");
        printOutput.printListElements(sortingTool.comparatorSort(toSort));
        System.out.println();
        System.out.println("Bubble Sort:");
        printOutput.printListElements(sortingTool.bubbleSort(toSort));
        System.out.println();
        System.out.println("Selection Sort:");
        printOutput.printListElements(sortingTool.selectionSort(toSort));
        System.out.println();
        System.out.println("Insertion Sort:");
        printOutput.printListElements(sortingTool.selectionSort(toSort));
    }
}
