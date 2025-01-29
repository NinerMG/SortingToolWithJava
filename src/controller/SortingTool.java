package controller;

import java.util.*;
import java.util.stream.Collectors;

public class SortingTool {

    //Sorting using streams
    public <T extends Comparable<T>> ArrayList<T> streamSort(ArrayList<T> list){
        checkIfListIsEmpty(list);
        return list.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //sorting using comparator interface
    public <T extends Comparable<T>> ArrayList<T> comparatorSort(ArrayList<T> list){
        checkIfListIsEmpty(list);
        list.sort(Comparable::compareTo);
        return list;
    }

    //sorting using bubble sort algorithm
    public <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> list){
        checkIfListIsEmpty(list);

        ArrayList<T> sortedList = new ArrayList<>(list);
        int n = sortedList.size();
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++){
                if (sortedList.get(i).compareTo(sortedList.get(i + 1)) > 0) {
                    T temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(i + 1));
                    sortedList.set(i+1, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        return sortedList;
    }

    private static <T extends Comparable<T>> void checkIfListIsEmpty(ArrayList<T> list) {
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("List is empty!");
        }
    }

    //sorting using selection sort algorithm
    public <T extends Comparable<T>> ArrayList<T> selectionSort(ArrayList<T> list) {
        checkIfListIsEmpty(list);
        ArrayList<T> sortedList = new ArrayList<>(list);
        int n = sortedList.size();

        for (int i = 0; i < n-1; i++){
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (sortedList.get(j).compareTo(sortedList.get(minIndex)) < 0){
                    minIndex = j;
                }
            }
            T temp = sortedList.get(minIndex);
            sortedList.set(minIndex, sortedList.get(i));
            sortedList.set(i, temp);
        }
        return sortedList;
    }

    //sorting using insertion sort algorithm
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> list) {
        checkIfListIsEmpty(list);
        ArrayList<T> sortedList = new ArrayList<>(list);
        int n = sortedList.size();

        for (int i = 1; i < n; i++){
            T key = sortedList.get(i);
            int j = i -1;

            while (j >= 0 && sortedList.get(j).compareTo(key) > 0){
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j+1, key);
        }
        return sortedList;
    }

    //sorting map by count value
    public <T extends Comparable<T>> Map<T, Long> sortingMapByCount(ArrayList<T> list){
        CountingTool countingTool = new CountingTool();
        Map<T, Long> mapToSort = countingTool.countElements(list);

        return mapToSort.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    int valueComparison = entry1.getValue().compareTo(entry2.getValue());
                    if (valueComparison != 0) {
                        return valueComparison;
                    }
                    return entry1.getKey().compareTo(entry2.getKey());
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
    }

}
