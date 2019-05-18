package com.company;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TextScanner ts = new TextScanner();
        String inputData = ts.readFile();
        TextBreaker tb = new TextBreaker();
        List<String> output = tb.getWords(inputData);
        SemanticCoreBuilder scb = new SemanticCoreBuilder();

        //System.out.println(inputData);
        StatisticBuilder statB = new StatisticBuilder();
        statB.buildTextStatistic(ts.getQuantityOfCymbols(inputData),
                ts.getQuantityOfCymbolsWithoutSpaces(inputData),
                output.size(), scb.getQuantityOfUniqueWords(ts.getMapOfUniqueWords(output)),
                6);


        try {
            Desktop.getDesktop().browse(scb.getResultFile().toURI());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test statistics");
        System.out.println("Quantity of cymbols " +ts.getQuantityOfCymbols(inputData));
        System.out.println("Quantity of cymbols without space " +ts.getQuantityOfCymbolsWithoutSpaces(inputData));
        System.out.println("Quantity of words in text " + output.size());
        System.out.println("Quantity of Unique words " +
                scb.getQuantityOfUniqueWords(ts.getMapOfUniqueWords(output)));
        scb.buildSemanticCore(ts.getMapOfUniqueWords(output));
        System.out.println("Quantity of stop-words ");
        System.out.println("Classic toshnota of document ");
        System.out.println("Academic toshnota of document ");
        System.out.println("Water" );

        System.out.println("Semantic Core ");
        //Here should be defined mostly used words , it's quantity and persent of usage

        System.out.println("Sorted text: " + output);
    }
}
