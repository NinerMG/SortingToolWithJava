package view;

import model.GenericList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;
    private GenericList<Object> genericList;

    public UserInput( ) {
        this.scanner = new Scanner(System.in);
        this.genericList = GenericList.getInstance();
    }

    public void getNumbers(){
        System.out.println("Wpisz liczby (Ctrl+D aby zakończyć):");
        while (scanner.hasNext()){
            try{
                Long number = scanner.nextLong();
                genericList.addElement(number);
            } catch (InputMismatchException e) {
                System.out.println("Error! Please enter number! Try again.");
                scanner.next();
            }

        }
    }

    public void getLines(){
        System.out.println("Wpisz liczby (Ctrl+D aby zakończyć):");
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()){
                genericList.addElement(line);
            }
        }
    }

    public void getWords(){
        System.out.println("Wpisz liczby (Ctrl+D aby zakończyć):");
        while (scanner.hasNext()){
            String word = scanner.next();
            genericList.addElement(word);
        }
    }

    public String getUserChoice(String message, String regex, String errorMessage) {
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! Try again.");
            } else if (!input.matches(regex)) {
                System.out.println(errorMessage);
            }
        } while (input.isEmpty() || !input.matches(regex));

        return input;
    }

    public String getDataTypes(){
        return getUserChoice(
                "Choose data type (numbers, lines, words):",
                "numbers|lines|words",
                "Error! Wrong data type! Try again."
        );
    }

    public String getSortingType(){
        return getUserChoice(
                "Choose sorting type (natural, byCount):",
                "natural|bycount",
                "Error! Wrong sorting type! Try again."
        );
    }
}
