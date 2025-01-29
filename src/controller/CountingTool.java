package controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingTool {

    public <T> Map<T, Long> countElements(ArrayList<T> list){
        if (list == null || list.isEmpty()){
            throw new IllegalArgumentException("Can't count elements on empty list!");
        }

        return list.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
    }
}
