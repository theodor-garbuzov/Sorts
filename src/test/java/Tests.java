import org.junit.Test;
import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Tests {
    //private static Sorter<T>[] SORTS = {MergeSort::sort};
    private Random rand = new Random();
    private int arrayNum = 5;
    private int[] length = {2, 10, 20, 250, 1000};
    private Integer[][] array = new Integer[arrayNum][];

    private void ArrInit() {
        for (int i = 0; i < arrayNum; ++i)
            array[i] = new Integer[length[i]];

        array[0][0] = 10;
        array[0][1] = -125;

        for (int i = 0; i < length[1]; ++i)
            array[1][i] = rand.nextInt(100);

        for (int i = 0; i < length[2]; ++i)
            array[2][i] = i;

        for (int i = 0; i < length[3]; ++i)
            array[3][i] = length[1] - i;

        for (int i = 0; i < length[4]; ++i)
            array[4][i] = rand.nextInt(10000);
    }

    @Test
    public void doNotCrash() {
        Integer[] array0 = new Integer[0];
        Integer[] array1 = new Integer[1];
        array1[0] = rand.nextInt();
        MergeSort.<Integer>sort(array0, Integer::compare);
        PermSort.<Integer>sort(array0, Integer::compare);
        MergeSort.<Integer>sort(array1, Integer::compare);
        PermSort.<Integer>sort(array1, Integer::compare);
    }

    @Test
    public void isSortedTest() {
        ArrInit();
        for (int i = 0; i < 3; ++i) {
            MergeSort.<Integer>sort(array[i], Integer::compare);
            PermSort.<Integer>sort(array[i], Integer::compare);
            assertEquals(isSorted(array[i], Integer::compare), true);
        }
        for (int i = 3; i < arrayNum; ++i) {
            MergeSort.<Integer>sort(array[i], Integer::compare);
            assertEquals(isSorted(array[i], Integer::compare), true);
        }
    }
    public <T> boolean isSorted(final T[] array, final Comparator<T> cmp) {
        int length = array.length;
        for (int i = 1; i < length; ++i)
            if (cmp.compare(array[i - 1], array[i]) > 0)
                return false;
        return true;
    }
}
