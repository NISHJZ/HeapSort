import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class HeapSortTest {

    private static final String SMALL_FILE_PATH = "small_arrays.txt";
    private static final String BIG_FILE_PATH = "big_arrays.txt";

    public static void main(String[] args) throws IOException {
        testOnSmallArrays();
        testOnBigArrays();
    }

    private static void testOnSmallArrays() throws IOException {
        System.out.println("Тестируем алгоритм на маленьком массиве...\n");
        BufferedReader reader = new BufferedReader(new FileReader(SMALL_FILE_PATH));

        String line;
        int iterationCount = 0;

        while ((line = reader.readLine()) != null) {
            String[] stringArray = line.split(" ");
            int[] array = new int[stringArray.length];
            for (int i = 0; i < stringArray.length; i++) {
                array[i] = Integer.parseInt(stringArray[i]);
            }

            long startTime = System.nanoTime();
            HeapSort.sort(array);
            long endTime = System.nanoTime();

            iterationCount += array.length * (int) Math.log(array.length);

            System.out.println("Отсортированный массив: " + Arrays.toString(array));
            System.out.println("Времени заняло: " + (endTime - startTime) + " миллисекунд");
            System.out.println("Счетчик итераций: " + iterationCount);
            System.out.println();
        }

        reader.close();
    }

    private static void testOnBigArrays() throws IOException {
        System.out.println("Тестируем алгоритм на большом массиве...\n");
        BufferedReader reader = new BufferedReader(new FileReader(BIG_FILE_PATH));

        String line = reader.readLine();
        String[] stringArray = line.split(" ");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        long startTime = System.nanoTime();
        HeapSort.sort(array);
        long endTime = System.nanoTime();

        int iterationCount = array.length * (int) Math.log(array.length);


//        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Времени заняло: " + (endTime - startTime) + " миллисекунд");
        System.out.println("Количество итераций: " + iterationCount);

        reader.close();
    }
}
