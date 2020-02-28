package nl.nuggit.countit;

import java.util.Arrays;

import nl.nuggit.countit.dependencies.AwesomeScrambler;
import nl.nuggit.countit.dependencies.InsertionSorter;
import nl.nuggit.countit.tools.Scrambler;
import nl.nuggit.countit.tools.Sorter;

public class WordProcessor {

    public static void main(String[] args) {

        Sorter sorter = new InsertionSorter();
        Scrambler scrambler = new AwesomeScrambler();
        CountIt countIt = new CountIt(sorter, scrambler);

        String document = getDocument(args);
        String[] lines = countIt.parse(document);
        Arrays.stream(lines).forEach(System.out::println);
    }

    private static String getDocument(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Please provide the document as a single program argument");
        }
        return args[0];
    }

}
