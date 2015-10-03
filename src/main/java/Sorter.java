import java.util.Comparator;

public interface Sorter<T> {
    void sort(final T[] array, final Comparator<T> cmp);
}
