package linkedList.reverseLinkedList;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;

/**
 * 反转一个单链表
 * 示例：
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution {
    public static ListNode reverseList(ListNode head){
        ListNode curr = head;
        head=null;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp =curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode temp=head;
        ListNode temp2=head;

        for (int i = 2; i < 6; i++) {
            temp.next=new ListNode(i);
            temp=temp.next;
        }


        for (int i = 0; i < 5; i++) {
            System.out.print(temp2.val);
            temp2=temp2.next;
        }

        ListNode temp3=reverseList(head);

        System.out.println();
        System.out.println("***********");

        for (int i = 0; i < 5; i++) {
            System.out.print(temp3.val);
            temp3=temp3.next;
        }


    }
}
