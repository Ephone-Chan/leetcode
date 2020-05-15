package lcof;

import util.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class P06_cong_wei_dao_tou_da_yin_lian_biao {


    /*
     *   反向输出，即“后进先出”，考虑“栈”和“递归”
     *
     * */

    // 栈实现
    public static int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        while (head != null) {

            stack.push(head.val);

            head = head.next;
        }

        int[] res = new int[stack.size()];

        int index = 0;

        while (!stack.empty()) {
            res[index++] = stack.pop();
        }

        return res;
    }


    //递归实现
    public static int[] reversePrint_recurse(ListNode head) {
        ListNode temp = head;

        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        int[] res = new int[count]; //创建数组容器

        recurseHelper(temp, res);

        return res;
    }

    public static int recurseHelper(ListNode node, int[] arr) {

        int index = 0;

        if (node.next != null) {
            //递归进入下一节点
            index = recurseHelper(node.next, arr);
            arr[index] = node.val;
            return index + 1;
        } else {
            //首个元素进入数组首位
            arr[index] = node.val;
            return index + 1;
        }
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);

        ListNode sec = new ListNode(2);
        head.next = sec;

        ListNode third = new ListNode(3);
        sec.next = third;

        ListNode forth = new ListNode(4);
        third.next = forth;


        int[] res = reversePrint_recurse(head);

        System.out.println(Arrays.toString(res));
    }
}
