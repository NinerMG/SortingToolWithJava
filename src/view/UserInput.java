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
        System.out.println("Enter numbers (Ctrl+D to finish):");
        readNumbers(scanner);
    }

    public void readNumbers(Scanner scanner) {
        while (scanner.hasNext()){
            try{
                Long number = scanner.nextLong();
                genericList.addElement(number);
            } catch (InputMismatchException e) {
                System.out.println("Error! Unexpected data type. Skipping: " + scanner.next());
            }
        }
    }

    public void getLines(){
        System.out.println("Enter lines of text (Ctrl+D to finish):");
        readLines(scanner);
    }

    public void readLines(Scanner scanner) {
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()){
                genericList.addElement(line);
            }
        }
    }

    public void getWords(){
        System.out.println("Enter words(Ctrl+D to finish):");
        readWords(scanner);
    }

    public void readWords(Scanner scanner) {
        while (scanner.hasNext()){
            String word = scanner.next();
            genericList.addElement(word);
        }
    }

    public String getUserChoice(String message, String regex, String errorMessage) {
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine().trim();

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
                "natural|byCount",
                "Error! Wrong sorting type! Try again."
        );
    }

    public String getFileInputChoice(String message){
        return getUserChoice(
                message,
                "yes|no",
                "Error! Wrong choice! Please enter 'yes' or 'no'."
        );
    }
}
