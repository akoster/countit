package nl.nuggit.countit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountIt {

    private Sorter sorter;

    public CountIt(Sorter sorter) {
        this.sorter = sorter;
    }

    public String[] parse(String document) {
        List<String> output = new ArrayList<>();
        String normalizedDocument = document.replaceAll("\\d+", "").toLowerCase();
        String[] words = normalizedDocument.split("\\W");
        output.add(String.format("Number of words: %s", words.length));
        output.addAll(countOccurrences(words));
        return output.toArray(new String[0]);
    }

    private List<String> countOccurrences(String[] words) {
        List<String> output = new ArrayList<>();
        Map<String, Integer> wordOccurrences = new HashMap<>();
        for (String word : words) {
            updateCount(wordOccurrences, word);
        }
        String[] distinctWords = wordOccurrences.keySet().toArray(new String[0]);
        sorter.sort(distinctWords);
        for (String word : distinctWords) {
            output.add(String.format("%s %s", word, wordOccurrences.get(word)));
        }
        return output;
    }

    private void updateCount(Map<String, Integer> wordOccurrences, String word) {
        Integer count = wordOccurrences.getOrDefault(word, 0);
        count = count + 1;
        wordOccurrences.put(word, count);
    }

}
