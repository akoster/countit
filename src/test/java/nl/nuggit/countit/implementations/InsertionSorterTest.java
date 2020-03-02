package nl.nuggit.countit.implementations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsertionSorterTest {

    private InsertionSorter instance = new InsertionSorter();

    @Test(expected = NullPointerException.class)
    public void valuesIsNull() {
        instance.sort(null);
    }

    @Test
    public void valuesIsEmpty() {
        instance.sort(new String[] {});
        // should not raise an exception
    }

    @Test
    public void singleValue() {
        String value = "42";
        String[] values = { value };

        instance.sort(values);

        assertEquals(value, values[0]);
    }

    @Test
    public void twoValues() {
        String[] values = new String[] { "0", "0" };

        instance.sort(values);

        assertEquals("0", values[0]);
        assertEquals("0", values[0]);
    }

    @Test
    public void mutlipleValues() {
        String[] values = new String[] { "2", "0", "3", "1" };

        instance.sort(values);

        assertEquals("0", values[0]);
        assertEquals("1", values[1]);
        assertEquals("2", values[2]);
        assertEquals("3", values[3]);
    }
}