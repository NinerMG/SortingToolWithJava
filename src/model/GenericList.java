package model;

import java.util.ArrayList;

public class GenericList <T>{
    private ArrayList<T> list;
    private static GenericList<?> instance;

    private GenericList(){
        this.list = new ArrayList<>();
    }

    public static synchronized <T> GenericList<T> getInstance(){
        if (instance == null){
            instance = new GenericList<>();
        }
        return (GenericList<T>) instance;
    }

    public void addElement(T element){
        list.add(element);
    }

    public int listSize(){
        return list.size();
    }

    public ArrayList<T> getList(){
        return list;
    }
}
