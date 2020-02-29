package nl.nuggit.countit.implementations;

import java.util.ArrayList;
import java.util.List;

import nl.nuggit.countit.components.Document;
import nl.nuggit.countit.components.DocumentFactory;
import nl.nuggit.countit.components.Parser;
import nl.nuggit.countit.components.Scrambler;
import nl.nuggit.countit.components.Sorter;

public class CountIt implements Parser {

    private Sorter sorter;
    private Scrambler scrambler;
    private DocumentFactory documentFactory;

    public CountIt(Sorter sorter, Scrambler scrambler, DocumentFactory documentFactory) {
        this.sorter = sorter;
        this.scrambler = scrambler;
        this.documentFactory = documentFactory;
    }

    public String[] parse(String text) {
        return parse(documentFactory.getDocument(text));
    }

    private String[] parse(Document document) {
        List<String> output = new ArrayList<>();

        output.add(String.format("Number of words: %s", document.numberOfWords()));

        String[] distinctWords = document.distinctWords();
        sorter.sort(distinctWords);

        for (String word : distinctWords) {
            output.add(String.format("%s %s", word, document.occurrenceCount(word)));
        }

        output.add("");

        for (String word : distinctWords) {
            output.add(scrambler.scramble(word));
        }

        return output.toArray(new String[0]);
    }

}
