/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = slow.next;
        ListNode head1 = head;
        ListNode head2 = null;
        slow.next = null;

        while(tail != null){
            ListNode next = tail.next;
            tail.next = head2;
            head2 = tail;
            tail = next;
        }

        boolean even = true;

        while(head1 != null && head2 != null){
            if(even){
                ListNode next = head1.next;
                head1.next = head2;
                head1 = next;
            }else{
                ListNode next = head2.next;
                head2.next = head1;
                head2 = next;
            }
            even = !even;
        }
    }
}
