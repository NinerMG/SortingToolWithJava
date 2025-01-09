package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortingTool {

    //Sorting using streams
    public ArrayList<Integer> streamSort(ArrayList<Integer> list){

        return list.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //sorting using comparator interface
    public ArrayList<Integer> comparatorSort(ArrayList<Integer> list){
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return list;
    }

    //sorting using bubble sort algorithm
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> list){
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        int n = sortedList.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++){
                if (sortedList.get(i) > sortedList.get(i + 1)) {
                    int temp = list.get(i);
                    sortedList.set(i, sortedList.get(i + 1));
                    sortedList.set(i+1, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return sortedList;
    }

    //sorting using selection sort algorithm
    public ArrayList<Integer> selectionSort(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        int n = sortedList.size();

        for (int i = 0; i < n-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (sortedList.get(j) < sortedList.get(minIndex)){
                    minIndex = j;
                }
            }
            int temp = sortedList.get(minIndex);
            sortedList.set(minIndex, sortedList.get(i));
            sortedList.set(i, temp);
        }
        return sortedList;
    }

    //sorting using insertion sort algorithm
    public ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        ArrayList<Integer> sortedList = new ArrayList<>(list);
        int n = sortedList.size();

        for (int i = 1; i < n; i++){
            int key = sortedList.get(i);
            int j = i -1;

            while (j >= 0 && sortedList.get(j) > key){
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j+1, key);
        }
        return sortedList;
    }

}
