package nl.nuggit.countit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CountItTest {

    private Sorter sorter = new MergeSorter();
    private CountIt countIt = new CountIt(sorter);

    @Test
    public void testNumbersAreIgnored() {
        String document = "number 4 ";

        String[] lines = countIt.parse(document);

        String output = String.join("\n", lines);
        assertFalse(output.contains("4"));
    }

    @Test
    public void testDotsAreIgnored() {
        String document = "dog.";

        String[] lines = countIt.parse(document);

        String output = String.join("\n", lines);
        assertFalse(output.contains("."));
    }

    @Test
    public void testOutputsTotalNumberOfWords() {
        String document = "The big brown fox";

        String[] lines = countIt.parse(document);

        assertEquals("Number of words: 4", lines[0]);
    }

    @Test
    public void testOutputsOccurrenceCountForEachWordInLowercase() {
        String document = "The Fox the dog";

        String[] lines = countIt.parse(document);

        String output = String.join("\n", lines);
        assertTrue(output.contains("the 2"));
        assertTrue(output.contains("fox 1"));
        assertTrue(output.contains("dog 1"));
    }

    @Test
    public void testOutputsOccurrenceCountsAlphabetical() {
        String document = "The quick brown fox";

        String[] lines = countIt.parse(document);

        assertEquals("brown 1", lines[1]);
        assertEquals("fox 1", lines[2]);
        assertEquals("quick 1", lines[3]);
        assertEquals("the 1", lines[4]);
    }

}
