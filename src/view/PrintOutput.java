package view;

import java.util.ArrayList;
import java.util.Map;

public class PrintOutput {

    public <T> void printElements(ArrayList<T> list){
        for (T element : list){
            System.out.print(" " + element);
        }
        System.out.println();
    }

    public <T> void printElementsWithNewLineEach(ArrayList<T> list){
        for (T element : list){
            System.out.println(" " + element);
        }
        System.out.println();
    }

    public <K> void printSortedElementsByCount(Map<K, Long> map){
        String text = " time(s), ";
        long totalOccurrences = map.values().stream().mapToLong(Long::longValue).sum();

        for (Map.Entry<K, Long> entry : map.entrySet()){
            long percentage = Math.round((double) (entry.getValue() * 100) / totalOccurrences);
            System.out.println(entry.getKey() + ": " + entry.getValue() + text + percentage + "%");
        }
    }


}
