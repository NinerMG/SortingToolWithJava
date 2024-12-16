package model;

import java.util.ArrayList;

public class WordList {
    private ArrayList<String> words;
    private static WordList instance;

    private WordList(){
        this.words = new ArrayList<>();
    }
    public static WordList getInstance(){
        if (instance == null){
            instance = new WordList();
        }
        return instance;
    }

    public void addWord(String word){
        words.add(word);
    }

    public int size(){
        return words.size();
    }

    public String longestWord(){
        String wordLongest = "";
        for (String word : words){
            if (word.length() > wordLongest.length()){
                wordLongest = word;
            }
        }
        return wordLongest;
    }
    public int getFrequencyMax(){
        String longestWord = longestWord();
        int frequency = 0;

        for (String word : words){
            if (word.equals(longestWord)){
                frequency++;
            }
        }
        return frequency;
    }

    public double getPercentageMax(){
        return getFrequencyMax() * 100.0 / size();
    }
}
