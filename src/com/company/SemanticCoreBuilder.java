package com.company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.management.ObjectName;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SemanticCoreBuilder {

    private int buffer;
    private int quantityOfwords;
    private int maximalValueOfWord;
    private float percentage;
    private float classicToshnota;
    private String maximalKeyOfWord;
    BufferedWriter result;
    FileOutputStream fos;
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
        sortedKeyValueData.putAll(keyValueData);

        for (int i = 0; i < keyValueData.size() ; i++) {
            quantityOfwords = quantityOfwords +
                    Integer.valueOf(keyValueData.
                            get(keyValueData.keySet().
                                    toArray()[i]).toString());
        }
        return quantityOfwords;
    }

    public void buildSemanticCore(Map keyValueData){
        quantityOfwords = getQuantityOfUniqueWords(keyValueData);
        maximalValueOfWord=0;
        buffer = 0;
        initializeResultFile();

        for (int i = 0; i <keyValueData.size() ; i++) {

            buffer = Integer.valueOf(keyValueData.
                    get(keyValueData.keySet().
                            toArray()[i]).toString());

            if (maximalValueOfWord < Integer.valueOf(keyValueData.
                    get(keyValueData.keySet().
                            toArray()[i]).toString()) )
            {
                maximalValueOfWord = buffer;
                maximalKeyOfWord = keyValueData.keySet().toArray()[i].toString();
            }


            percentage = ((float) Integer.valueOf(keyValueData.
                    get(keyValueData.keySet().
                            toArray()[i]).toString()) /  quantityOfwords) * 100;

//            System.out.println("Values collection from map - " +
//                    keyValueData.keySet().toArray()[i]  + " - " +
//                    keyValueData.get(keyValueData.keySet().toArray()[i]) + " - " +
//                    percentage + " %"
//            );
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
            System.out.println( sortedKeyValueData.keySet().toArray()[i]  + " - " + sortedKeyValueData.get(sortedKeyValueData.keySet().toArray()[i]));
         }
        try {
            result.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( "Word \"" + maximalKeyOfWord + "\" has maximal value " +
                maximalValueOfWord);
    }


}
