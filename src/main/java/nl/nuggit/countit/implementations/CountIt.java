package nl.nuggit.countit.implementations;

import java.util.ArrayList;
import java.util.List;

import nl.nuggit.countit.components.Parser;
import nl.nuggit.countit.components.Scrambler;
import nl.nuggit.countit.components.Sorter;

public class CountIt implements Parser {

    private Sorter sorter;
    private Scrambler scrambler;

    public CountIt(Sorter sorter, Scrambler scrambler) {
        this.sorter = sorter;
        this.scrambler = scrambler;
    }

    public String[] parse(String text) {
        return parse(new Document(text));
    }

    private String[] parse(Document document) {
        List<String> output = new ArrayList<>();

        output.add(String.format("Number of words: %s", document.countWords()));

        String[] distinctWords = document.getDistinctWords();
        sorter.sort(distinctWords);

        for (String word : distinctWords) {
            output.add(String.format("%s %s", word, document.countOccurrences(word)));
        }

        output.add("");

        for (String word : distinctWords) {
            output.add(scrambler.scramble(word));
        }

        return output.toArray(new String[0]);
    }

}
