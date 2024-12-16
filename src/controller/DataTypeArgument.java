package controller;

import view.UserInput;

public class DataTypeArgument {
    UserInput userInput;
    static String dataTypeArgumentChoice;
    private final String defaultArgument = "word";

    public DataTypeArgument(){
        userInput = new UserInput();
        String line = userInput.getDataType();
        setDataTypeArgumentChoice(line);
    }

    private boolean containsDataType(String line){
        return line.contains("-dataType");
    }
    private void setDataTypeArgumentChoice(String line){
        if (containsDataType(line)){
            if (line.contains("long")){
                dataTypeArgumentChoice = "long";
            } else if (line.contains("line")) dataTypeArgumentChoice = "line";
            else if (line.contains("word")) dataTypeArgumentChoice = "word";
            else dataTypeArgumentChoice = defaultArgument;
        } else {
            System.out.println("Wrong java SortingTool expression! Missing -dataType keyword!");
        }
    }
}
