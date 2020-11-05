package linkedList.cycle;


import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

/*
//HashSet
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodeHashSet = new HashSet<ListNode>();
        while (head != null) {
            if (!listNodeHashSet.add(head)) {
                return true;
            }
            head =head.next;
        }
        return false;
    }
}

//快慢指针
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}
*/