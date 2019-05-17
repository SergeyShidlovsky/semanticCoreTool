package com.company;

import javax.management.ObjectName;
import java.util.*;
import java.util.stream.Collectors;

public class SemanticCoreBuilder {

    private int buffer;
    private int quantityOfwords;
    private int maximalValueOfWord;
    private float percentage;
    private float classicToshnota;
    private String maximalKeyOfWord;


    Map <String, Integer> sortedKeyValueData = new TreeMap<>();


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

            System.out.println( sortedKeyValueData.keySet().toArray()[i]  + " - " + sortedKeyValueData.get(sortedKeyValueData.keySet().toArray()[i]));
         }
        System.out.println( "Word \"" + maximalKeyOfWord + "\" has maximal value " +
                maximalValueOfWord);
    }


}
