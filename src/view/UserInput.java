package view;

import model.LineList;
import model.NumberList;
import model.WordList;

import java.util.Scanner;

public class UserInput {
    NumberList numberList;
    LineList lineList;
    WordList wordList;

    public UserInput(){
        numberList = NumberList.getInstance();
        lineList = LineList.getInstance();
        wordList = WordList.getInstance();
    }

    public String getDataType(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void getNumbers(){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLong()){
                numberList.addNumber(scanner.nextLong());
        }
    }

    public void getLines(){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()){
                lineList.addLine(line);
            }
        }
    }

    public void getWords(){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String word = scanner.next();
            wordList.addWord(word);
        }
    }
}
