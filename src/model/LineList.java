package model;

import java.util.ArrayList;


public class LineList {

    private ArrayList<String> lines;
    private static LineList instance;

    private LineList(){
        this.lines = new ArrayList<>();
    }
    public static LineList getInstance(){
        if (instance == null){
            instance = new LineList();
        }
        return instance;
    }

    public void addLine(String line){
        lines.add(line);
    }
    public int size(){
        return lines.size();
    }
    public String longestLine(){
        String longestLineTemp = "";

        for (String line : lines){
            if (line.length() > longestLineTemp.length()){
                longestLineTemp = line;
            }
        }
        return longestLineTemp;
    }

    public int getFrequencyMax(){
        String lineTemp = longestLine();
        int frequency = 0;

        for (String line : lines){
            if (line.equals(lineTemp)){
                frequency++;
            }
        }
        return frequency;
    }

    public double getPercentageMax(){
        return getFrequencyMax() * 100.0 / size();
    }
}
