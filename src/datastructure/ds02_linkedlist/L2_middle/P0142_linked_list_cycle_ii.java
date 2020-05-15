package datastructure.ds02_linkedlist.L2_middle;

import util.ListNode;

public class P0142_linked_list_cycle_ii {

    public static ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        ListNode p1 = head, p2 = head;

        while(p1 != null){

            p1 = p1.next;

            p2 = p2.next;
            if(p2 != null && p2.next != null)
                p2 = p2.next;
            else
                return null;

            if(p1 == p2)
                break;
        }

        int count = 1;
        p2 = p2.next;

        while(p2 != p1){
            p2 = p2.next;
            count++;
        }

        if(count == 1)
            return p2;

        p1 = head; p2 = head;

        while(count >= 1){
            p2 = p2.next;
            count--;
        }

        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l3;

        System.out.println(detectCycle(l1).val);

    }


}
