package nl.nuggit.countit;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CountItTest {

    private CountIt countIt = new CountIt();

    @Test
    public void testNumbersAreIgnored() {
        String document = "test 123";

        String output = countIt.parse(document);

        assertFalse(output.contains("123"));

    }

}
