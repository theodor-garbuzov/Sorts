import java.util.Comparator;

public class PermSort {

    public static <T> void sort(final T[] array, final Comparator<T> cmp) {
        // Check all permutations where element with index n IS NOT on it's origin place
        int n = 0;
        boolean isSorted = false;
        while (!isSorted) {
            assert (n < array.length);
            isSorted = PermSortAlgorithm(array, cmp, n);
            ++n;
        }
    }

    // PermSortAlgorithm looks through all permutations where element with index n is not on it's origin place
    private static <T> boolean PermSortAlgorithm(final T[] array, final Comparator cmp, final int n) {
        if(isSorted(array, cmp))
            return true;
        for (int i = n + 1; i < array.length; ++i) {
            swap(array, n, i);
            for (int j = n + 1; j < array.length; ++j) {
                if (PermSortAlgorithm(array, cmp, j))
                    return true;
            }
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