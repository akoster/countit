package nl.nuggit.countit;

public class WordProcessor {

    public static void main(String[] args) {
        String document = getDocument(args);
        CountIt countIt = new CountIt();
        String output = countIt.parse(document);
    }

    private static String getDocument(String[] args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Please provide the document as a single program argument");
        }
        return args[0];
    }

}
