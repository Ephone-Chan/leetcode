package middle;

import java.util.*;

public class ThreeSum {

    /*
    排序后的双指针搜索
    1.排序可以保证结果的非降序添加至 List<Integer> 中
    2.每个位置都要跳过重复的数字，首层的跳过在 for 循环的底部，内层的跳过在满足 a + b + c 的情况下使用双指针进行跳过重复的数字
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                if ((nums[i] + nums[start] + nums[end]) == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    start++;
                    end--;
                    while (start < end && nums[start] == nums[start - 1])
                        start++;
                    while (start < end && nums[end] == nums[end + 1])
                        end--;
                } else if (nums[start] + nums[end] + nums[i] > 0)
                    end--;
                else
                    start++;
            }

            while (i < nums.length-1 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {5, 5, 5, 5, 5, 5};

        ThreeSum solution = new ThreeSum();

        System.out.println(solution.threeSum(nums));
    }
}
