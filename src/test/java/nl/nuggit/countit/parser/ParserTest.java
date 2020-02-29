package nl.nuggit.countit.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import nl.nuggit.countit.ComponentFactory;
import nl.nuggit.countit.components.Parser;
import org.junit.Test;

public class ParserTest {

    private Parser parser = ComponentFactory.getParser();

    @Test
    public void numbersAreIgnored() {
        String document = "one 1 two 2 three 3 ";

        String[] lines = parser.parse(document);

        assertEquals("Number of words: 3", lines[0]);
    }

    @Test
    public void dotsAreIgnored() {
        String document = "The big. brown. fox.... ";

        String[] lines = parser.parse(document);

        assertEquals("Number of words: 4", lines[0]);
    }

    @Test
    public void outputsTotalNumberOfWords() {
        String document = "The big brown fox ";

        String[] lines = parser.parse(document);

        assertEquals("Number of words: 4", lines[0]);
    }

    @Test
    public void outputsOccurrenceCountForEachWordInLowercase() {
        String document = "The Fox the dog";

        String[] lines = parser.parse(document);

        String output = String.join("\n", lines);
        assertTrue(output.contains("the 2"));
        assertTrue(output.contains("fox 1"));
        assertTrue(output.contains("dog 1"));
    }

    @Test
    public void outputsOccurrenceCountsAlphabetical() {
        String document = "The quick brown fox";

        String[] lines = parser.parse(document);

        assertEquals("brown 1", lines[1]);
        assertEquals("fox 1", lines[2]);
        assertEquals("quick 1", lines[3]);
        assertEquals("the 1", lines[4]);
    }

    @Test
    public void outputsScrambledWords() {
        String document = "The quick brown fox";

        String[] lines = parser.parse(document);

        assertEquals("", lines[5]);

        assertEquals("nWoRb", lines[6]);
        assertEquals("xOf", lines[7]);
        assertEquals("kCiUq", lines[8]);
        assertEquals("eHt", lines[9]);
    }

    @Test
    public void approvalTest() {
        String document = "The big brown fox number 4 jumped over the lazy dog. THE BIG BROWN FOX JUMPED OVER THE "
                + "LAZY DOG. The Big Brown Fox 123.";

        String[] lines = parser.parse(document);

        String output = String.join("\n", lines);
        assertEquals(
                "Number of words: 23\n" + "big 3\n" + "brown 3\n" + "dog 2\n" + "fox 3\n" + "jumped 2\n" + "lazy 2\n"
                        + "number 1\n" + "over 2\n" + "the 5\n" + "\n" + "gIb\n" + "nWoRb\n" + "gOd\n" + "xOf\n"
                        + "dEpMuJ\n" + "yZaL\n" + "rEbMuN\n" + "rEvO\n" + "eHt", output);
    }
}
