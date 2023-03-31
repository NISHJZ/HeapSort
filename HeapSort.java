public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        // Построить кучу (переупорядочить массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // По одному извлекаем элемент из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Переместить текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // вызов max heapify для уменьшенной кучи
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализировать наибольший как root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // Если левый потомок больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый потомок больше самого большого на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно увеличиваем затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}
