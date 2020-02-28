package nl.nuggit.countit;

import java.util.HashMap;
import java.util.Map;

public class CountIt {

    public String parse(String document) {
        String normalizedDocument = document.replaceAll("\\d+", "").toLowerCase();
        String[] words = normalizedDocument.split("\\W");
        String wordCount = String.format("Number of words: %s%n", words.length);
        String wordOccurrences = countOccurrences(words);
        return wordCount + wordOccurrences;
    }

    private String countOccurrences(String[] words) {
        Map<String, Integer> wordOccurrences = new HashMap<>();
        for (String word : words) {
            updateCount(wordOccurrences, word);
        }
        StringBuilder occurrenceOutput = new StringBuilder();
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            occurrenceOutput.append(String.format("%s %s%n", entry.getKey(), entry.getValue()));
        }

        return occurrenceOutput.toString();
    }

    private void updateCount(Map<String, Integer> wordOccurrences, String word) {
        Integer count = wordOccurrences.getOrDefault(word, 0);
        count = count + 1;
        wordOccurrences.put(word, count);
    }

}
