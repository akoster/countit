package nl.nuggit.countit.implementations;

import java.util.Arrays;

import nl.nuggit.countit.components.Sorter;

public class SystemSorter implements Sorter {

    @Override
    public void sort(String[] values) {
        // use built-in sort algorithm instead of rolling your own, less code to maintain
        Arrays.sort(values);
    }

}
