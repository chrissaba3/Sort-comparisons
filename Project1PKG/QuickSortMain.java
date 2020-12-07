package Project1PKG;
import java.time.Instant;
import java.time.Duration;
import java.util.*;
public class QuickSortMain {
    public static void main(String[] args) {
        Random rd = new Random();
        int array[] = new int[125000]; //array problem size
        System.out.println("Given Array: ");

        Instant start = Instant.now();
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.abs(rd.nextInt(10000));         //Fill array with random elements, and calculate time to create
        }
        Instant end = Instant.now();
        System.out.println();
        System.out.println(Duration.between(start, end));

        System.out.println();
        System.out.println("Sorted Array using QuickSort:");

        QuickSortMain obj = new QuickSortMain();
        start = Instant.now();

        obj.sort(array, 0, array.length - 1);       //sort the array with QuickSort, and calculate time to sort


        System.out.println();
        end = Instant.now();
        System.out.println(Duration.between(start, end));   //print time

    }
    int split(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = split(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}