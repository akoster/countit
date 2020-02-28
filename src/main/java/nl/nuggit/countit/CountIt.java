package nl.nuggit.countit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.nuggit.countit.tools.Scrambler;
import nl.nuggit.countit.tools.Sorter;

public class CountIt {

    private Sorter sorter;
    private Scrambler scrambler;

    public CountIt(Sorter sorter, Scrambler scrambler) {
        this.sorter = sorter;
        this.scrambler = scrambler;
    }

    public String[] parse(String document) {
        String[] words = getWords(document);

        List<String> output = new ArrayList<>();

        output.add(String.format("Number of words: %s", words.length));

        Map<String, Integer> wordOccurrences = new HashMap<>();
        for (String word : words) {
            updateCount(wordOccurrences, word);
        }

        String[] distinctWords = wordOccurrences.keySet().toArray(new String[0]);
        sorter.sort(distinctWords);

        for (String word : distinctWords) {
            output.add(String.format("%s %s", word, wordOccurrences.get(word)));
        }
        output.add("");

        for (String word : distinctWords) {
            output.add(scrambler.scramble(word));
        }

        return output.toArray(new String[0]);
    }

    private String[] getWords(String document) {
        String normalizedDocument = document.replaceAll("\\d+", "").toLowerCase();
        return normalizedDocument.split("\\W");
    }

    private void updateCount(Map<String, Integer> wordOccurrences, String word) {
        Integer count = wordOccurrences.getOrDefault(word, 0);
        count = count + 1;
        wordOccurrences.put(word, count);
    }

}
