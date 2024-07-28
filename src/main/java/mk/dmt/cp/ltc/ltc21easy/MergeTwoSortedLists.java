package mk.dmt.cp.ltc.ltc21easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list = mergeTwoLists(list1, list2);
        printList(list);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return new ListNode(list2.val, list2.next);
        if(list2 == null) return new ListNode(list1.val, list1.next);
        if(list1.val <= list2.val) {
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
    }

    private static void printList(ListNode list) {
        while(list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}


