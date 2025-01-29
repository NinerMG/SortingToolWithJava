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
        } else if (!(instance instanceof GenericList<?>)){
            throw new IllegalStateException("Error with instance of GenericList class!");
        }
        return (GenericList<T>) instance;
    }

    public void addElement(T element){
        list.add(element);
    }

    public ArrayList<T> getList(){
        return list;
    }
}
