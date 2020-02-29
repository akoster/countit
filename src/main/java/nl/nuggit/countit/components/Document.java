package nl.nuggit.countit.components;

public interface Document {

    int numberOfWords();

    String[] distinctWords();

    int occurrenceCount(String word);
}
