package Chapter13;

import java.util.Arrays;

public class Sort {

    public static void sort(int[] numbers) {
        long start = System.currentTimeMillis();
//        heapsort(numbers);
        Arrays.sort(numbers);
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println((end-start) + " миллисекунд");
    }

    // sort num[1] to num[n]
    public static void heapsort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--)
            // convert the array to a heap
            shiftDown(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i); /* deleteMax */
            shiftDown(a, 0, i);
        }
    } // end heapSort

    private static void shiftDown(int[] a, int i, int n) {
        int child;
        int tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && (a[child] < a[child + 1]))
                child++;
            if (tmp < a[child])
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // swap numbers
    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

} // end class ExampleHeapSort