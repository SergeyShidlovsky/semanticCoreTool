package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TextScanner ts = new TextScanner();
        String inputData = ts.readFile();
        TextBreaker tb = new TextBreaker();
        List<String> output = TextBreaker.getWords(inputData);
        System.out.println("Sorted text: " + output);
    }
}
