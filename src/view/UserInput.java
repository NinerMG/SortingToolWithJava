package view;

import model.GenericList;
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
        while (scanner.hasNextLong()){
            Long number = scanner.nextLong();
            genericList.addElement(number);
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

    public String getDataTypes(){
        return scanner.nextLine();
    }

    public String getSortingType(){
        return scanner.nextLine();
    }
}
