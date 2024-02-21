import java.util.*;

public class Merge_K_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        // Complexity -> O(nlogK);    // where n is the total number of elements in all lists and k is the number of lists

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode one, ListNode two) {
                return one.val - two.val;          // since the pq is a min Heap, so we did { one.val - two.val } otherwise { two.val - one.val }
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (pq.size() != 0) {
            ListNode rv = pq.poll();
            dummy.next = rv;
            dummy = dummy.next;

            if (rv.next != null) {
                pq.add(rv.next);
            }
        }
        return temp.next;

        // Below Code Complexity -> O(nlogN);

        // ListNode node = new ListNode(0);
        // ListNode head = node;

        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for(ListNode temp : lists) {
        // while(temp!= null) {
        // pq.add(temp.val);
        // temp = temp.next;
        // }
        // }

        // while(pq.size()>0) {
        // ListNode l = new ListNode(pq.poll());
        // node.next = l;
        // node = node.next;
        // }
        // return head.next;
    }
}
