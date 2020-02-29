package nl.nuggit.countit.implementations;

import java.util.Arrays;
import java.util.HashSet;

public class Document {

    private String[] words;

    public Document(String text) {
        words = normalize(text);
    }

    private String[] normalize(String document) {
        return document.replaceAll("\\d+", "").toLowerCase().split("\\W+");
    }

    public int countWords() {
        return words.length;
    }

    public String[] getDistinctWords() {
        return new HashSet<>(Arrays.asList(words)).toArray(new String[0]);
    }

    public int countOccurrences(String word) {
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

}
