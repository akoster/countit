package nl.nuggit.countit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CountItTest {

    private CountIt countIt = new CountIt();

    @Test
    public void testNumbersAreIgnored() {
        String document = "number 4 ";

        String output = countIt.parse(document);

        assertFalse(output.contains("4"));
    }


    @Test
    public void testDotsAreIgnored() {
        String document = "dog.";

        String output = countIt.parse(document);

        assertFalse(output.contains("."));
    }

    @Test
    public void testOutputsTotalNumberOfWords() {
        String document = "The big brown fox";

        String output = countIt.parse(document);

        assertTrue(output, output.startsWith("Number of words: 4"));
    }

    @Test
    public void testOutputsOccurrenceCountForEachWordInLowercase() {
        String document = "The Fox the dog";

        String output = countIt.parse(document);

        assertTrue(output.contains("the 2"));
        assertTrue(output.contains("fox 1"));
        assertTrue(output.contains("dog 1"));
    }

}
