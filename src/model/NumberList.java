package model;

import java.util.ArrayList;

public class NumberList {

    private ArrayList<Integer> list;
    private static NumberList instance;

    public NumberList(){
        this.list = new ArrayList<>();
    }

    public static synchronized NumberList getInstance(){
        if (instance == null){
            instance = new NumberList();
        }
        return instance;
    }

    public void addNumber(int number){
        list.add(number);
    }
    public int listSize(){
        return list.size();
    }

    public ArrayList<Integer> getList(){
        return list;
    }
    public void printElements(){
        for (Integer element : list){
            System.out.print(" " + element);
        }
        System.out.println();
    }
}
