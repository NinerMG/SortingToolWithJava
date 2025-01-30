package controller;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class SimpleFileSave {

    public <T> void fileSaveToTxt(ArrayList<T> listToSave, String headline){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/output.txt", true))){
            writer.write(headline);
            writer.newLine();
            for (T element : listToSave){
                writer.write(String.valueOf(element));
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public <T extends Comparable<T>> void fileSaveToTxt(Map<T, Long> mapSorted, String headline) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("resources/output.txt", true))){
            writer.write(headline);
            writer.newLine();

            long totalOccurences = mapSorted.values().stream().mapToLong(Long::longValue).sum();

            for (Map.Entry<T, Long> entry : mapSorted.entrySet()){
                long percentage = Math.round((double) (entry.getValue() * 100) / totalOccurences);
                writer.write(entry.getKey() + ": " + entry.getValue() + " time(s), " + percentage + "%");
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
