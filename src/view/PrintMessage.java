package view;

import model.LineList;
import model.NumberList;
import model.WordList;

public class PrintMessage {
    NumberList numberList;
    LineList lineList;
    WordList wordList;

    public PrintMessage(){
        numberList = NumberList.getInstance();
        lineList = LineList.getInstance();
        wordList = WordList.getInstance();
    }

    public void printOutputForNumbers(){
        System.out.printf("Total numbers: %d.",
                numberList.size());
        System.out.println();
        System.out.printf("The greatest number: %d (%d time(s), %.0f%%).%n",
                numberList.maximumValue(),
                numberList.getFrequency(numberList.maximumValue()),
                numberList.getPercentageFreq()
        );
    }

    public void printOutputForLines(){
        System.out.printf("Total lines: %d.",
                lineList.size());
        System.out.println();
        System.out.printf("The longest line:%n%s %n(%d time(s), %.0f%%).%n",
                lineList.longestLine(),
                lineList.getFrequencyMax(),
                lineList.getPercentageMax()
        );
    }

    public void printOutputForWords(){
        System.out.printf("Total words: %d.",
                wordList.size());
        System.out.println();
        System.out.printf("The longest word: %s (%d time(s), %.0f%%).%n",
                wordList.longestWord(),
                wordList.getFrequencyMax(),
                wordList.getPercentageMax()
        );
    }
}
