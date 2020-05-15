package algorithm.alg08_bitoperation.L1_easy;

public class P0136_single_number {

    public static int singleNumber(int[] nums) {

        if(nums == null )
            return -1;

        if(nums.length == 1)
            return nums[0];

        int res = 0;


        for(int i = 0; i < nums.length; i++)
            res ^= nums[i];


        return res;
    }



    public static void main(String[] args){
        int[] arr = {4,1,1,2,2,3,3};


        System.out.println(singleNumber(arr));
    }
}
