package nl.nuggit.countit.implementations;

import nl.nuggit.countit.components.Sorter;

public class InsertionSorter implements Sorter {

    @Override
    public void sort(String[] values) {
        for (int i = 1; i < values.length; i++) {
            String current = values[i];
            int j = i - 1;
            while (j >= 0 && smallerThan(current, values[j])) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = current;
        }
    }

    private boolean smallerThan(String a, String b) {
        return a.compareTo(b) < 0;
    }

}
