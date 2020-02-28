package nl.nuggit.countit;

import java.util.Arrays;

public class WordProcessor {

    public static void main(String[] args) {
        Sorter sorter = new MergeSorter();
        CountIt countIt = new CountIt(sorter);
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
