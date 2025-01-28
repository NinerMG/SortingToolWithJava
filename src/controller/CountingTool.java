package controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class CountingTool {

    public <T> Map<T, Long> countElements(ArrayList<T> list){
        return list.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
    }
}
