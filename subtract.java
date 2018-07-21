/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        ListNode endNode = null;
        ListNode startNode = A;
        ArrayList<Integer> values = new ArrayList<Integer>();
        int count = 0;
        while (startNode != null) {
            values.add(startNode.val);
            // System.out.println("Adding value " + startNode.val);
            endNode = startNode.next;
            startNode = endNode;
            count++;
        }
        int half = count/2;
        // System.out.println("Found count " + count + " half = " + half);
        startNode = A;
        ListNode solution = new ListNode(0);
        ListNode currentNode = solution;
        for (int i=0; i < half; i++) {
            // System.out.println("Looking at end  " + (count-i-1) + " start = " + i);
            currentNode.val = values.get(count-i-1) - values.get(i);
            // System.out.println("currentNode is  " + currentNode.val);
            ListNode newNode = new ListNode(0);
            currentNode.next = newNode;
            currentNode = newNode;
            // startNode = startNode.next;
        }
        for (int i=half; i < count; i++) {
            currentNode.val = values.get(i);
            // System.out.println("currentNode is  " + currentNode.val);
            if ((i + 1) < count) {
                ListNode newNode = new ListNode(0);
                currentNode.next = newNode;
                currentNode = newNode;
            }
        }
        return solution;
    }
}
