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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // take lowest value node from list1 or list2
        ListNode head = new ListNode();
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            // set result.next as min between list1 and list2
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // add the rest of the remaining list if there is any
        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }
}