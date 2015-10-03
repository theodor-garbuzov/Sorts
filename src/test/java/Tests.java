import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

enum ArrayType {RANDOM, SORTED_INCREASE, SORTED_DECREASE}

public class Tests {
    private static List<Sorter<Integer>> SORTS = new ArrayList<>();
    static {
        SORTS.add(MergeSort::sort);
    }

    private Integer[] generateArray(final int count, final ArrayType arrayType) {
        Integer[] array = new Integer[count];
        if (arrayType == ArrayType.RANDOM) {
            Random rand = new Random();
            for (int i = 0; i < count; ++i)
                array[i] = rand.nextInt(10000);
        }
        else if (arrayType == ArrayType.SORTED_INCREASE) {
            for (int i = 0; i < count; ++i)
                array[i] = i;
        }
        else {
            for (int i = 0; i < count; ++i)
                array[i] = count - i;
        }
        return array;
    }

    @Test
    public void doNotCrash() {
        Integer[] array0 = new Integer[0];
        Integer[] array1 = new Integer[1];
        array1[0] = 123;
        for (Sorter<Integer> sort : SORTS) {
            sort.sort(array0, Integer::compare);
            sort.sort(array1, Integer::compare);
        }
    }

    @Test
    public void isSortedTest() {
        final int count = 101;
        for (Sorter<Integer> sort : SORTS) {
            final Integer[] arr = generateArray(count, ArrayType.RANDOM);
            sort.sort(arr, Integer::compare);
            assertTrue(isSorted(arr, Integer::compare));
        }
    }
    public <T> boolean isSorted(final T[] array, final Comparator<T> cmp) {
        final int length = array.length;
        for (int i = 1; i < length; ++i)
            if (cmp.compare(array[i - 1], array[i]) > 0)
                return false;
        return true;
    }
}
