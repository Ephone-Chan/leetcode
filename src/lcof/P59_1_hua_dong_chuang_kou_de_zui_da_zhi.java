package lcof;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P59_1_hua_dong_chuang_kou_de_zui_da_zhi {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length < k)
            return new int[0];


        int[] res = new int[nums.length - k + 1];

        //存储索引
        Deque<Integer> deque = new LinkedList<>();

        //初始化窗口
        //后面的元素肯定是要进队的，区别在于“是否需要剔除前面的元素”
        for (int i = 0; i < k; i++) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();

            deque.add(i);
        }


        //窗口移动
        for (int i = k; i <= nums.length; i++) {

            res[i - k] = nums[deque.peek()];

            //后进元素大于队尾元素时，队尾出队
            while (!deque.isEmpty() && i < nums.length && nums[i] > nums[deque.peekLast()])
                deque.pollLast();

            deque.add(i);

            // 脱离窗口的元素出队
            if (i - deque.peek() >= k)
                deque.poll();
        }

        return res;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 2)));

    }


}
