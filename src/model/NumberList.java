package model;

import java.util.ArrayList;
import java.util.Collections;

public class NumberList {

    private ArrayList<Long> numbers;
    private static NumberList instance;

    private NumberList(){
        this.numbers = new ArrayList<>();
    }

    public static NumberList getInstance(){
        if(instance == null){
            instance = new NumberList();
        }
        return instance;
    }

    public void addNumber(long number){
        numbers.add(number);
    }
    public int size(){
        return numbers.size();
    }
    public long maximumValue(){
       if(numbers.isEmpty()){
           return 0;
       }
       return Collections.max(numbers);
    }

    public int getFrequency(long number){
        return Collections.frequency(numbers, number);
    }

    public double getPercentageFreq(){
        return getFrequency(maximumValue()) * 100.0 / size();
    }

}
