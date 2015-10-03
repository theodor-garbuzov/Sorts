import java.util.Comparator;

public class PermSort {

    public static <T> void sort(final T[] array, final Comparator<T> cmp) {
        PermSortAlgorithm(array, cmp, 0);
    }

    private static <T> boolean PermSortAlgorithm(final T[] array, final Comparator cmp, final int n) {
        if(isSorted(array, cmp))
            return true;
        for (int i = n + 1; i < array.length; ++i) {
            swap(array, n, i);
            if (PermSortAlgorithm(array, cmp, n + 1))
                return true;
            swap(array, n, i);
        }
        return false;
    }

    private static <T> boolean isSorted(final T[] array, final Comparator<T> cmp) {
        int length = array.length;
        for (int i = 1; i < length; ++i)
            if (cmp.compare(array[i - 1], array[i]) > 0)
                return false;
        return true;
    }

    private static <T> void swap(final T[] array, final int i1, final int i2) {
        T tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}