package nl.nuggit.countit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import nl.nuggit.countit.dependencies.AwesomeScrambler;
import nl.nuggit.countit.dependencies.InsertionSorter;
import nl.nuggit.countit.tools.Scrambler;
import nl.nuggit.countit.tools.Sorter;
import org.junit.Test;

public class CountItTest {

    private Sorter sorter = new InsertionSorter();
    private Scrambler scrambler = new AwesomeScrambler();
    private CountIt countIt = new CountIt(sorter, scrambler);

    @Test
    public void numbersAreIgnored() {
        String document = "number 4 ";

        String[] lines = countIt.parse(document);

        String output = String.join("\n", lines);
        assertFalse(output.contains("4"));
    }

    @Test
    public void dotsAreIgnored() {
        String document = "dog.";

        String[] lines = countIt.parse(document);

        String output = String.join("\n", lines);
        assertFalse(output.contains("."));
    }

    @Test
    public void outputsTotalNumberOfWords() {
        String document = "The big brown fox";

        String[] lines = countIt.parse(document);

        assertEquals("Number of words: 4", lines[0]);
    }

    @Test
    public void outputsOccurrenceCountForEachWordInLowercase() {
        String document = "The Fox the dog";

        String[] lines = countIt.parse(document);

        String output = String.join("\n", lines);
        assertTrue(output.contains("the 2"));
        assertTrue(output.contains("fox 1"));
        assertTrue(output.contains("dog 1"));
    }

    @Test
    public void outputsOccurrenceCountsAlphabetical() {
        String document = "The quick brown fox";

        String[] lines = countIt.parse(document);

        assertEquals("brown 1", lines[1]);
        assertEquals("fox 1", lines[2]);
        assertEquals("quick 1", lines[3]);
        assertEquals("the 1", lines[4]);
    }

    @Test
    public void outputsScrambledWords() {
        String document = "The quick brown fox";

        String[] lines = countIt.parse(document);

        assertEquals("", lines[5]);
        assertEquals("nWoRb", lines[6]);
        assertEquals("xOf", lines[7]);
        assertEquals("kCiUq", lines[8]);
        assertEquals("eHt", lines[9]);
    }
}
