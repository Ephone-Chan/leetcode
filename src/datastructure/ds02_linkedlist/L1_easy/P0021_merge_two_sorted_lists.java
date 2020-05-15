package datastructure.ds02_linkedlist.L1_easy;

import util.ListNode;

public class P0021_merge_two_sorted_lists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        ListNode res = new ListNode(1);
        ListNode start = res;

        if(l1.val <= l2.val){
            res.val = l1.val;
            l1 = l1.next;
        }
        else{
            res.val = l2.val;
            l2 = l2.next;
        }

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                res.next = l1;
                l1 = l1.next;
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if(l1!=null)
            res.next = l1;
        if(l2!=null)
            res.next = l2;

        return start;
    }

    public static void main(String[] args){

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        System.out.println(mergeTwoLists(l1,l2));
    }
}
