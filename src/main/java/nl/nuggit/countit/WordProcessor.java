package nl.nuggit.countit;

import java.util.Arrays;

import nl.nuggit.countit.components.Parser;

public class WordProcessor {

    public static void main(String[] args) {
        String text = getText(args);
        Parser parser = ComponentFactory.getParser();
        printOutput(parser.parse(text));
    }

    private static String getText(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Please provide text as a single quoted argument");
        }
        return args[0];
    }

    private static void printOutput(String[] lines) {
        Arrays.stream(lines).forEach(System.out::println);
    }
}
