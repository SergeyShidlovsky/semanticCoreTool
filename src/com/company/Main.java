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
        scb.buildSemanticCore(ts.getMapOfUniqueWords(output));

        Library lb = new Library();
        scb.getQuantityOfStopWords(ts.getMapOfUniqueWords(output) ,lb.getStopArray());

        StatisticBuilder statB = new StatisticBuilder();
        statB.buildTextStatistic(ts.getQuantityOfCymbols(inputData),
                ts.getQuantityOfCymbolsWithoutSpaces(inputData),
                output.size(),
                scb.getQuantityOfUniqueWords(ts.getMapOfUniqueWords(output)),
                scb.getQuantityOfStopWords(ts.getMapOfUniqueWords(output),lb.getStopArray()),
                scb.getWater());


        ResultPresenter present = new ResultPresenter();
        present.presentResult(scb.getResultFile().toURI());



        System.out.println("Water" );

        System.out.println("Semantic Core ");
        //Here should be defined mostly used words , it's quantity and persent of usage

        System.out.println("Sorted text: " + output);
    }
}
