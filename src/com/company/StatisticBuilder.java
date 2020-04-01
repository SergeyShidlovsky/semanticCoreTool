package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StatisticBuilder {


    BufferedWriter statistic;

    public void initializeStatisticFile(){

        try {
            statistic = new BufferedWriter(new FileWriter("../../semanticCoreTool/statistic.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildTextStatistic(int quantityOfCymbols,
                                   int quantityOfCymbolsWithoutSpaces,
                                   int quantityOfWords,
                                   int quantityOfUniqueWords,
                                   int quantityOfStopWords,
                                   float water
    ) {
        initializeStatisticFile();

        try {
            statistic.write("Кількість Символів - " + quantityOfCymbols);
            statistic.newLine();
            statistic.write("Кількість символів без пробілу - " + quantityOfCymbolsWithoutSpaces);
            statistic.newLine();
            statistic.write("Кількість Слів - " + quantityOfWords);
            statistic.newLine();
            statistic.write("Кількість Унікальних Слів - " + quantityOfUniqueWords);
            statistic.newLine();
            statistic.write("Кількість Cтоп Слів - " + quantityOfStopWords);
            statistic.newLine();
            statistic.write("Вода тексту - " + water + "  %");

            statistic.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
