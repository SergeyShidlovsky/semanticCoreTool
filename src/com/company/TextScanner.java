package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class TextScanner {

    private FileInputStream fis;
    private byte[] buffer;
    private File path;
    private int quantityOfCymbols;
    int iterator;
    String compareWord;
    String nextWord;
    String curr;


    public String readFile(){
        try {
            path = new File("../../semanticCoreTool/source.txt");
            fis = new FileInputStream(path);
            buffer = new byte[fis.available()];

            fis.read(buffer, 0, buffer.length);
            String content = new String (buffer);
            fis.close();
            return content;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "This string will not be returned";
    }

    public int getQuantityOfCymbols(String content){
        return quantityOfCymbols = content.length();
    }

    public int getQuantityOfCymbolsWithouSpaces(String content){
        for (int i = 0; i < content.length(); i++) {
            if (content.toCharArray()[i] != ' ') {
                quantityOfCymbols++;
            }
        }
        return quantityOfCymbols;
    }

    public void getQuantityOfUniqueWords(List<String> context){
            for (int i = 0; i < context.size(); i++) {

                compareWord = context.get(i);
                if (i!=(context.size()-1)){
                    nextWord = context.get(i+1);
                }
                if(!compareWord.equals(nextWord)){
                    for (int j = 0; j < context.size(); j++) {
                        curr = context.get(j);
                        if (compareWord.equals(curr)) {
                            iterator++;
                        }
                    }
                    System.out.println(compareWord + "  - " + iterator);
                }
                //System.out.println(compareWord + "  - " + iterator);
                iterator = 0;
            }
    }
}
