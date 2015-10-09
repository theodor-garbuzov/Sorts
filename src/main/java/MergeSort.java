import java.util.Comparator;
import static java.lang.Integer.min;

public class MergeSort {

    public static <T> void sort(final T[] array, final Comparator<T> cmp) {
        final int length = array.length;
        int first, mid, last;
        int width;
        for (width = 2; width < length; width = width << 1) {
            for (int i = 0; i < length; i += width) {
                first = i;
                mid = (first + i + width - 1) >> 1;
                last = min(i + width - 1, length - 1);
                merge(array, first, mid, last, cmp);
            }
        }
        merge(array, 0, (width >> 1) - 1, length - 1, cmp);
    }

    private static <T> void merge(final T[] array, int first, int mid, int last, final Comparator<T> cmp) {
        if (last <= first) return;
        int left = first;
        int right = mid + 1;
        while (left <= mid && right <= last) {
            if (cmp.compare(array[left], array[right]) <= 0)
                left++;
            else {
                T tmp = array[right];
                ArrayShift(array, left, right - left);
                array[left] = tmp;
                left++;
                mid++;
                right++;
            }
        }
    }

    private static <T> void ArrayShift(final T[] array, final int srcInd, final int elemNum) {
        for (int i = srcInd + elemNum; i > srcInd; --i)
            array[i] = array[i - 1];
    }
}
