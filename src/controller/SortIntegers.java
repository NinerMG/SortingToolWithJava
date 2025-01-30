package controller;

import model.GenericList;
import view.PrintOutput;
import view.UserInput;

import java.util.ArrayList;

public class SortIntegers {
    UserInput userInput;
    SortingTool sortingTool;
    PrintOutput printOutput;
    GenericList genericList;
    SimpleFileReader simpleFileReader;
    SimpleFileSave simpleFileSave;

    public SortIntegers(){
        userInput = new UserInput();
        sortingTool = new SortingTool();
        printOutput = new PrintOutput();
        genericList = GenericList.getInstance();
        simpleFileReader = new SimpleFileReader();
        simpleFileSave = new SimpleFileSave();

        appLoop();
    }

    private void appLoop(){
        String dataType = userInput.getDataTypes();
        String sortingType = userInput.getSortingType();
        String fileChoice = userInput.getFileInputChoice("Do you want to read data from a file? (yes/no):");

        if("yes".equals(fileChoice)){
            simpleFileReader.readingFile(dataType);
            processData(genericList.getList(), sortingType, dataType);
        } else {
            switch (dataType) {
                case "numbers":
                    userInput.getNumbers();
                    processData(genericList.getList(), sortingType, "numbers");
                    break;
                case "lines":
                    userInput.getLines();
                    processData(genericList.getList(), sortingType, "lines");
                    break;
                case "words":
                    userInput.getWords();
                    processData(genericList.getList(), sortingType, "words");
                    break;
                default:
                    System.out.println("Wrong data type. Please try again!");
            }
        }
    }

    private <T extends Comparable<T>> void processData(ArrayList<T> list, String sortingType, String dataType) {
        if ( list == null || list.isEmpty()){
            System.out.println("No data to sort.");
            return;
        }

        System.out.println("Your unsorted list: ");
        simpleFileSave.fileSaveToTxt(list, "Unsorted list:");
        printList(dataType, list);
        System.out.println("Total " + dataType + ": " + list.size() + ".");

        try {
            if ("natural".equals(sortingType)) {
                System.out.println("Sorted data: ");
                printList(dataType, sortingTool.streamSort(list));
                simpleFileSave.fileSaveToTxt(sortingTool.streamSort(list), "Sorted natural:");
            } else if ("byCount".equals(sortingType)) {
                System.out.println("Sorting by Count");
                printOutput.printSortedElementsByCount(sortingTool.sortingMapByCount(list));
               simpleFileSave.fileSaveToTxt(sortingTool.sortingMapByCount(list), "Sorted byCount");
            } else {
               throw new IllegalArgumentException("Unexpected sorting type.");
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private <T> void printList(String dataType, ArrayList<T> list){
        switch(dataType){
            case "words":
            case "numbers":
                printOutput.printElements(list);
                break;
            case "lines":
                printOutput.printElementsWithNewLineEach(list);
                break;
            default:
                System.out.println("Unknown type");
        }
    }
    }
