package lcci;

public class P1001_sorted_merge {


    //由尾部开始的归并
    public static void merge(int[] A, int m, int[] B, int n) {

        int i = m-1, j = n-1, k = A.length - 1;

        for(; k >= 0;){

            if(i < 0){
                A[k--] = B[j--];
                continue;
            }

            if(j < 0)
                break;

            if(A[i] >= B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
    }
}
