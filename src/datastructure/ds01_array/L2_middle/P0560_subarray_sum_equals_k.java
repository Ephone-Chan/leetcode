package datastructure.ds01_array.L2_middle;

import java.util.HashMap;
import java.util.Map;

public class P0560_subarray_sum_equals_k {


    public static int subarraySumBruteForce(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){

            int sum = 0;

            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }


    public static int subarraySumCache(int[] nums, int k) {

        int sum = 0, count = 0;

        Map<Integer,Integer> preSumCount = new HashMap<>();

        preSumCount.put(0,1);

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];

            if(preSumCount.containsKey(sum - k))
                count += preSumCount.get(sum-k);

            preSumCount.put(sum, preSumCount.getOrDefault(sum, 0)+1);
        }

        return count;
    }


    public static void main(String[] args){

        System.out.println(subarraySumCache(new int[] {1,1,1,-1,0,2,0,2,0,2}, 2));

        System.out.println(subarraySumBruteForce(new int[] {1,1,1,-1,0,2,0,2,0,2}, 2));

    }
}
