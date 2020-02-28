package nl.nuggit.countit;

public class CountIt {

    public String parse(String document) {
        String output = document.replaceAll("\\d+", "");
        String[] words = output.split("\\s+");
        return String.format("Number of words: %s", words.length);
    }

}
