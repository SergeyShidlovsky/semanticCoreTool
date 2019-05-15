package com.company;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class TextBreaker {

    // Based on Solution
    // http://qaru.site/questions/179094/converting-a-sentence-string-to-a-string-array-of-words-in-java
    private  List<String> words;

    public  List<String> getWords(String text) {
        words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {

            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        return words;
    }
}
