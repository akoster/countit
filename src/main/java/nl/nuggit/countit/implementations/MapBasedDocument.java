package nl.nuggit.countit.implementations;

import java.util.HashMap;
import java.util.Map;

import nl.nuggit.countit.components.Document;

public class MapBasedDocument implements Document {

    private String[] words;
    private Map<String, Integer> occurrences;

    public MapBasedDocument(String document) {
        words = normalize(document);
        occurrences = countOccurrences(words);
    }

    private String[] normalize(String document) {
        return document.replaceAll("\\d+", "").toLowerCase().split("\\W+");
    }

    public int numberOfWords() {
        return words.length;
    }

    public String[] distinctWords() {
        return occurrences.keySet().toArray(new String[0]);
    }

    public int occurrenceCount(String word) {
        return occurrences.get(word);
    }

    private Map<String, Integer> countOccurrences(String[] words) {
        //  Collect occurrenceCounts by iterating the words once. Faster, but uses more memory.
        Map<String, Integer> occurrences = new HashMap<>();
        for (String word : words) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }
        return occurrences;
    }

}
