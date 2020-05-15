package algorithm.alg03_divideconquer.L1_easy;

public class P0053_maximum_subarray {


    /*
        最大子序列和，分治算法的实现
     */

    private int maxSubSum(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        } else {
            int m = (start + end) / 2;

            int leftMax = maxSubSum(nums, start, m);

            int rightMax = maxSubSum(nums, m + 1, end);

            int s1 = Integer.MIN_VALUE, ltemp = 0;
            for (int i = m; i >= start; i--) {
                ltemp += nums[i];
                if (ltemp > s1)
                    s1 = ltemp;
            }

            int s2 = Integer.MIN_VALUE, rtemp = 0;
            for (int i = m + 1; i <= end; i++) {
                rtemp += nums[i];
                if (rtemp > s2)
                    s2 = rtemp;
            }

            int sum = s1 + s2;

            if (leftMax > sum) sum = leftMax;

            if (rightMax > sum) sum = rightMax;

            return sum;
        }
    }

    public static void main(String[] args) {

        int[] nums = {-2, 1};

        P0053_maximum_subarray maxSubArray = new P0053_maximum_subarray();

        int res = maxSubArray.maxSubSum(nums, 0, nums.length - 1);

        System.out.println(res);
    }

}
