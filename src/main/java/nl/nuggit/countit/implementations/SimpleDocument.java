package nl.nuggit.countit.implementations;

import java.util.Arrays;
import java.util.HashSet;

import nl.nuggit.countit.components.Document;

public class SimpleDocument implements Document {

    private String[] words;

    public SimpleDocument(String text) {
        words = normalize(text);
    }

    private String[] normalize(String document) {
        return document.replaceAll("\\d+", "").toLowerCase().split("\\W+");
    }

    public int numberOfWords() {
        return words.length;
    }

    public String[] distinctWords() {
        return new HashSet<>(Arrays.asList(words)).toArray(new String[0]);
    }

    public int occurrenceCount(String word) {
        //  Iterates the words for each occurrenceCount. Slower, but uses less memory.
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

}
