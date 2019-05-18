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
                                   int academicToshnota) {
        initializeStatisticFile();

        try {
            statistic.write("Кількість Символів - " + String.valueOf(quantityOfCymbols));
            statistic.newLine();
            statistic.write("Кількість символів без пробілу - " + quantityOfCymbolsWithoutSpaces);
            statistic.newLine();
            statistic.write("Кількість Слів - " + quantityOfWords);
            statistic.newLine();            statistic.write("Кількість Унікальних Слів - " + quantityOfUniqueWords);
            statistic.write("Академічна Частита  - " + academicToshnota);
            statistic.write(" %");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
