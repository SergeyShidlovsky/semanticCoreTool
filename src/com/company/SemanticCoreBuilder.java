package com.company;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class SemanticCoreBuilder {

    private int buffer;
    private int quantityOfwords;
    private int maximalValueOfWord;
    private int quantityOfStopWords;
    private float water;
    private float percentage;
    private float classicToshnota;
    private String maximalKeyOfWord;
    public BufferedWriter result;
    public File resultFile;

    private static DecimalFormat df = new DecimalFormat("0.00");

    Map <String, Integer> sortedKeyValueData = new TreeMap<>();

    public void initializeResultFile(){
        try {
            //result = new FileWriter("../../semanticCoreTool/result.txt");
            result = new BufferedWriter(new FileWriter("../../semanticCoreTool/result.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getQuantityOfUniqueWords(Map keyValueData){
        quantityOfwords = 0;
        for (int i = 0; i < keyValueData.size() ; i++) {
            quantityOfwords = quantityOfwords +
                    Integer.valueOf(keyValueData.
                            get(keyValueData.keySet().
                                    toArray()[i]).toString());
        }
        return quantityOfwords;
    }

    public void buildSemanticCore(Map keyValueData){
        sortedKeyValueData.putAll(keyValueData);

        quantityOfwords = getQuantityOfUniqueWords(sortedKeyValueData);
        buffer = 0;
        initializeResultFile();

        for (int i = 0; i < sortedKeyValueData.size() ; i++) {

            percentage = ((float) Integer.valueOf(sortedKeyValueData.
                    get(sortedKeyValueData.keySet().
                            toArray()[i]).toString()) /  quantityOfwords) * 100;

           try {
                result.write(sortedKeyValueData.keySet().toArray()[i].toString());
                result.write( " - ");
                result.write(sortedKeyValueData.get(sortedKeyValueData.keySet().toArray()[i]).toString());
                result.write( " - ");
                result.write(df.format(percentage));
                result.write( " %");
                result.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
        try {
            result.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "Word \"" + maximalKeyOfWord + "\" has maximal value " +
                maximalValueOfWord);
    }

    public File getResultFile(){
        resultFile = new File(this.getClass().getResource("result.html").getFile());
        return resultFile;
    }

    public int getQuantityOfStopWords(Map keyValueData, String[] stopArray){
        quantityOfStopWords = 0;
        for (int i = 0; i <keyValueData.size() ; i++) {

            for (int j = 0; j < stopArray.length; j++) {
                if((keyValueData.keySet().toArray()[i].toString().toLowerCase()).equals(
                stopArray[j].toLowerCase())){
                    quantityOfStopWords++;
                    System.out.print(keyValueData.keySet().toArray()[i].toString() + "  ");
                    break;
                }
            }
        }
        return quantityOfStopWords;
    }

    public float getWater(){
        water = (float) ((quantityOfStopWords * 100 / quantityOfwords));
        System.out.println("water " + water);
        return water;
    }
}
