package nl.nuggit.countit;

public class MergeSorter implements Sorter {

    @Override
    public void sort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String current = array[i];
            int j = i - 1;
            while (j >= 0 && current.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

}
