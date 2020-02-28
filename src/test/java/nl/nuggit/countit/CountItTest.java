package nl.nuggit.countit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CountItTest {

    private CountIt countIt = new CountIt();

    @Test
    public void testNumbersAreIgnored() {
        String document = "The big brown fox number 4 ";

        String output = countIt.parse(document);

        assertFalse(output.contains("4"));
    }

    @Test
    public void testOutputsTotalNumberOfWords() {
        String document = "The big brown fox number 4 ";

        String output = countIt.parse(document);

        String expectedStart = "Number of words: 5";
        assertTrue(output.startsWith(expectedStart));

    }

}
