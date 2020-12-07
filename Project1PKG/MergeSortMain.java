package Project1PKG;
import java.time.Instant;
import java.time.Duration;
import java.util.*;
public class MergeSortMain {
    public static void main(String [] args){
        Random rd = new Random();       //Random for array contents
        int array[] = new int[12500];   //size of array, max dependant on computer
        System.out.println("Given Array: ");

        Instant start = Instant.now();      //starts timer
        for(int i = 0; i< array.length; i++){
            array[i] = Math.abs(rd.nextInt(10000));
        }
        Instant end = Instant.now();        //ends timer
        System.out.println();
        System.out.println(Duration.between(start, end));       //prints time difference between end and start, which gives total alloted time

        System.out.println();
        System.out.println("Sorted Array using MergeSort:");

        MergeSortMain obj = new MergeSortMain();
        start = Instant.now();                  //starts timer again

        obj.sort(array, 0, array.length-1);     //Sorting algorithm start



        System.out.println();
        end = Instant.now();        //end timer
        System.out.println(Duration.between(start, end));   //print time

    }


    static void merge(int array[], int l, int m, int r){

        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int [n1];
        int R[] = new int [n2];

        //Copy data to temp arrays
        for (int i=0; i<n1; ++i)
            L[i] = array[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = array[m + 1+ j];


        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                array[k] = L[i];
                i++;
            }
            else
            {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1)
        {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2)
        {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}
