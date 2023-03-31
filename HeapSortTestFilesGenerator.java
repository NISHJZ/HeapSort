import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class HeapSortTestFilesGenerator {

    private static final String SMALL_FILE_PATH = "small_arrays.txt";
    private static final String BIG_FILE_PATH = "big_arrays.txt";
    private static final int SMALL_ARRAY_SIZE = 10;
    private static final int BIG_ARRAY_SIZE = 100000;

    public static void main(String[] args) throws IOException {
        generateSmallArraysFile();
        generateBigArraysFile();
    }

    private static void generateSmallArraysFile() throws IOException {
        File file = new File(SMALL_FILE_PATH);
        FileWriter writer = new FileWriter(file);

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < SMALL_ARRAY_SIZE; j++) {
                writer.write(random.nextInt() + " ");
            }
            writer.write("\n");
        }

        writer.close();
    }

    private static void generateBigArraysFile() throws IOException {
        File file = new File(BIG_FILE_PATH);
        FileWriter writer = new FileWriter(file);

        Random random = new Random();
        for (int i = 0; i < BIG_ARRAY_SIZE; i++) {
            writer.write(random.nextInt() + " ");
        }

        writer.close();
    }
}
