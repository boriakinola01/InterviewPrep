import java.util.HashMap;
import java.util.List;

 class ListNode {
    ListNode next;
    int data;
    public ListNode(){};
    public ListNode(int data){
        this.data = data;
    }
}

class LinkedList{
    private ListNode head;

    public void append(int data){
        if(head == null){
            head = new ListNode(data);
            return;
        }

        ListNode current = head;

        while(current.next != null){
            current = current.next;
        }

        current.next = new ListNode(data);
    }

    public void prepend(int data){
        ListNode current = new ListNode(data);
        current.next = head;
        head = current;
    }

    public void deleteWithValue(int data){
        if (head == null) return;
        if(head.data == data){
            head = head.next;
        }
        ListNode current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }

    // Add two numbers represented as linkedLists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        ListNode head = new ListNode(0);
        ListNode l3 = head;

        int carry = 0;
        while(l1!= null | l2!=null){
            // if one number has one digit more than the other


            // if l1 is not equal to null, set the value to l1.data
            // if null, set to 0
            int l1Val = (l1 != null) ? l1.data : 0;
            // if l2 is not equal to null, set the value to l2.data
            // if null, set to 0
            int l2Val = (l2 != null) ? l2.data :0;

            int current_sum = l1Val + l2Val + carry;
            carry = current_sum / 10;
            int remainder = current_sum % 10;

            ListNode newNode = new ListNode(remainder);
            l3.next = newNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if(carry > 0){
            l3.next = new ListNode(carry);
            l3 = l3.next;
        }

        return head.next;
    }

    // Check if a linkedList is a palindrome
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        slow = reverseList(slow);
        quick = head;
        while(slow != null){
            slow = slow.next;
            quick = quick.next;

            if(slow.data != quick.data)
                return false;
        }
        return true;
    }

    // reverse a linked list
    public ListNode reverseList(ListNode node){
        ListNode prev = null;

        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    // Merging two sorted lists
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode check = new ListNode(2);
        ListNode node = check;

        while(list1!=null && list2!=null) {
            if (list1.data < list2.data) {
                check.next = list1;
                list1 = list1.next;
            } else {
                check.next = list2;
                list2 = list2.next;
            }
            check = check.next;

            if(list1 != null){
                check.next = list1;
            } else {
                check.next = list2;
            }

        }
        return node.next;
    }

}
