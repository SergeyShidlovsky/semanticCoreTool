package com.company;

import java.util.Map;

public class SemanticCoreBuilder {

    private int quantityOfwords;
    private float percentage;
    private float classicToshnota;


    public int getQuantityOfUniqueWords(Map keyValueData){

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

        for (int i = 0; i <keyValueData.size() ; i++) {
            percentage = ((float) Integer.valueOf(keyValueData.
                    get(keyValueData.keySet().
                            toArray()[i]).toString()) /  quantityOfwords) * 100;
            System.out.println("Values collection from map - " +
                    keyValueData.keySet().toArray()[i]  + " - " +
                    keyValueData.get(keyValueData.keySet().toArray()[i]) + " - " +
                    percentage + " %"
            );
         }
    }
}
