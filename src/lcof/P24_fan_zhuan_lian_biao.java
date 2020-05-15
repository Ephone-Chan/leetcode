package lcof;

import util.ListNode;

public class P24_fan_zhuan_lian_biao {

    public static ListNode reverseList(ListNode head) {

        // 1. 当前节点的 next 需要 指向 前一节点
        // 1-1. 前一节点的引用需要保留
        // 1-2. 当前节点的 next 在被前一节点的引用覆盖前需要保留，确保向后走

        // 2.末端节点的 next 为空，在切换 currentNext 时，需要对末端节点进行特殊处理；


        if(head == null)
            return null;

        ListNode preNode = null;    // 首节点的前一节点为 null

        ListNode currentNext = head.next;    // 保留当前节点的 next

        ListNode currentNode = head;    // 当前节点


//        // next 指针作为终止条件
//        while (currentNext != null){
//
//            currentNode.next = preNode; // 当前节点的 next 指向前一节点引用
//
//            preNode = currentNode;  // 当前节点变为后续节点的前一节点
//
//            currentNode = currentNext; // 当前节点向后走
//
//            currentNext = currentNode.next; // 保留当前节点的下一指针
//
//            // 末端节点处理
//            if(currentNext == null){
//                currentNode.next = preNode;
//            }
//        }
//        return currentNode;


        // currentNode 作为终止条件
        while(currentNode != null){

            currentNext = currentNode.next; //下一节点的指针保留

            currentNode.next = preNode; //指向上一节点

            preNode = currentNode;

            currentNode = currentNext;  //向下走
        }
        return preNode;
    }

    public static void main(String[] args){

        ListNode head = new ListNode(1);

        ListNode sec = new ListNode(2);
        head.next = sec;

        ListNode third = new ListNode(3);
        sec.next = third;

        ListNode forth = new ListNode(4);
        third.next = forth;


        ListNode res = reverseList(head);


        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
}
