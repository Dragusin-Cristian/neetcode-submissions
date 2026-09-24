

//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }


class Solution {
    public ListNode reverseList(ListNode head) {
        // traverse the list

        // save the node as current, previous node as prev, and next as next

        // change the .next of current node to prev

        // change the current to next

        // do until node.next is null (inclusively), then return node

        // handle edge cases: empty list or list of 1;
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode prev = new ListNode(head.val);
        ListNode curr = new ListNode(head.next.val, head.next.next);

        while (curr.next != null) {
            ListNode next = new ListNode(curr.next.val, curr.next.next);
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr.next = prev;
        return curr;

    }
}
