package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class TextScanner {

    private FileInputStream fis;
    private byte[] buffer;
    private File path;
    private int quantityOfCymbols;
    private int iterator;
    private String compareWord;
    private String nextWord;
    private String curr;

    //Set key = new HashSet();
    //Set value = new HashSet();
    Map map = new HashMap();


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
        quantityOfCymbols =0;
        for (int i = 0; i < content.length(); i++) {

            quantityOfCymbols++;
        }

        return quantityOfCymbols;
    }

    public int getQuantityOfCymbolsWithoutSpaces(String content){
        quantityOfCymbols =0;
        for (int i = 0; i < content.length(); i++) {
            if (content.toCharArray()[i] != ' ') {
                quantityOfCymbols++;
            }
        }
        return quantityOfCymbols;
    }

    public Map getMapOfUniqueWords(List<String> context){
        for (int i = 1; i < context.size(); i++) {

            compareWord = context.get(i-1);
            if (i!=(context.size()-1)){
                nextWord = context.get(i);
            }
            else{
                nextWord = context.get(i-1);
            }
            if(!compareWord.equals(nextWord)){
                for (int j = 0; j < context.size(); j++) {
                    curr = context.get(j);
                    if (compareWord.equals(curr)) {
                        iterator++;
                    }
                }
                map.putIfAbsent(compareWord.toLowerCase(),iterator);
            }
            iterator = 0;
        }
        return map;
    }
}
