package week4day2.practice;

import inputreader.InputReader;

import java.io.*;

class TestSorting {
    public static void main(String[] args) throws IOException {
        File input = new File("src/week4day2/practice/input.txt");
        FileWriter output = new FileWriter("src/week4day2/practice/output.txt", false);

        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            output.write("Testcase " + (t + 1) + ":- \n");

            int n = ir.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = ir.nextInt();
            }

            displaySortedArr(output,"Bubble Sort: ", new BubbleSort().bubbleSortOptimized(arr, n));
            displaySortedArr(output,"Insertion Sort: ", new InsertionSort().insertionSort(arr, n));
            displaySortedArr(output,"Selection Sort: ", new SelectionSort().selectionSort(arr, n));
            displaySortedArr(output,"Merge Sort: ", new MergeSort().mergeSort(arr, 0, n - 1));

            displaySortedArr(output,"Bucket Sort: ", new BucketSort().bucketSort(arr, n));
            displaySortedArr(output,"Counting Sort: ", new CountingSort().countingSort(arr, n));

            output.write("\n");
        }

        output.close();
    }

    private static void displaySortedArr(FileWriter output, String s, int[] arr) throws IOException {
        output.write(s);
        for (int j : arr ) { output.write(j + " "); }
        output.write("\n");
    }
}
