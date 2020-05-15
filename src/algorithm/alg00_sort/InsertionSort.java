package algorithm.alg00_sort;

import java.util.Arrays;

public class InsertionSort {


    public static void insertSort(int[] arr) {

        for (int i = 1; i <= arr.length - 1; i++) {

            int temp = arr[i];
            int j = i - 1;

            while (j >= 0) {
                if (arr[j] > temp)
                    arr[j + 1] = arr[j];
                else
                    break;
                j--;
            }
            arr[j+1] = temp;

            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args){

        int[] arr = {5,4,2,1,7,4,3,1};

        insertSort(arr);
    }
}
