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
    int iterator;
    String compareWord;
    String nextWord;
    String curr;

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
        return quantityOfCymbols = content.length();
    }

    public int getQuantityOfCymbolsWithoutSpaces(String content){
        for (int i = 0; i < content.length(); i++) {
            if (content.toCharArray()[i] != ' ') {
                quantityOfCymbols++;
            }
        }
        return quantityOfCymbols;
    }

    public Map getQuantityOfUniqueWords(List<String> context){
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
                //System.out.println(compareWord + "  - " + iterator);
               // key.add(compareWord);
                //value.add(iterator);
                map.putIfAbsent(compareWord.toLowerCase(),iterator);
            }
            iterator = 0;
        }
//        System.out.println("arraylist output");
//        for (int i = 0; i <key.size() ; i++) {
//            System.out.print(key.toArray()[i] + " - ");
//        }
//        System.out.println();
//        for (int i = 0; i <map.size() ; i++) {
//            System.out.println("Values collection from map - " + map.keySet().toArray()[i]  + " - " + map.get(map.keySet().toArray()[i]));
//        }
        return map;
    }
}
