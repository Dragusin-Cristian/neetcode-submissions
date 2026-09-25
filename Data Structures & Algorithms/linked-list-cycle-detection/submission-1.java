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
    public boolean hasCycle(ListNode head) {

        // edge cases: empty list
        if (head == null) return false;

        Set<Integer> visited = new HashSet<>();
        ListNode curr = head;
        while (curr.next != null) {
            if (visited.contains(curr.val)) {
                return true;
            } else {
                visited.add(curr.val);
                curr = curr.next;
            }
        }

        return false;
    }
}
