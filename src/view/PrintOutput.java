package view;

import java.util.ArrayList;

public class PrintOutput {

    public void printListElements(ArrayList<Integer> list){
        for (Integer element : list){
            System.out.print(" " + element);
        }
        System.out.println();
    }
}
