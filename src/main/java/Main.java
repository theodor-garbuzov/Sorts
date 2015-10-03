import java.util.Random;

public class Main {

    private static int length = 10;
    private static Integer[] array = new Integer[length];

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < length; ++i)
            array[i] = length - i;
        PermSort.<Integer>sort(array, Integer::compare);
        for (int i = 0; i < length; ++i)
            System.out.print(array[i] + " ");
    }
}