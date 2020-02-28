package nl.nuggit.countit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CountItTest {

    @Test
    public void testDocumentCanBeParsed() {

        CountIt countIt = new CountIt();
        String document = "test";
        String output = countIt.parse(document);
        assertEquals(document, output);

    }

}
