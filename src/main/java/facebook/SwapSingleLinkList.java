package facebook;

   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class SwapSingleLinkList {

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head ;
        ListNode first = head ;
        ListNode second = head.next ;
        ListNode third = head.next.next ;

        second.next = first ;
        head= second;
        first.next = swapPairs(third) ;

        return head;
    }
}
