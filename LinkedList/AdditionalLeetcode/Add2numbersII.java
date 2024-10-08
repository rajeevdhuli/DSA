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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int carry = 0;
        while(a != null || b != null || carry == 1){
            int sum = 0 ;
            sum+= carry;
            if(a != null){
                sum+= a.val;
                a = a.next;
            }
            if(b != null){
                sum+= b.val;
                b = b.next;
            }
            // carry cannot be more than1 beacuse max case 9+9+1 = 19
            carry = (sum < 10) ? 0 : 1;
            sum = (sum < 10) ? sum : (sum % 10);
            ListNode temp = new ListNode(sum);
            head.next = temp;
            head = head.next;
        }
        return reverse(ans.next);
        
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}



Using stack-


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while(a != null){
            st1.push(a.val);
            a = a.next;
        }
        while(b != null){
            st2.push(b.val);
            b = b.next;
        }
        ListNode ans = new ListNode(-1);
        ListNode head = ans;
        int carry = 0;
        while((!st1.isEmpty()) || (!st2.isEmpty()) || carry == 1){
            int sum = 0 ;
            sum+= carry;
            if(!st1.isEmpty()){
                sum+= st1.pop();
            }
            if(!st2.isEmpty()){
                sum+= st2.pop();
            }
            // carry cannot be more than1 beacuse max case 9+9+1 = 19
            carry = (sum < 10) ? 0 : 1;
            sum = (sum < 10) ? sum : (sum % 10);
            head.val = sum;
            // Move the head pointer and create a new node at the front
            ListNode temp = new ListNode(0);
            temp.next = head;
            head = temp;
        }
        return head.next;
    }
}



            head.val = sum;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            head = dummy;


you are changing the value of head(calcuate sum of last digit) and then insert at end of linked list, by creating a dummy.
example - sum for last digit is 7,next digit is 4
so first inset 7 in head, then dummy of -1 . -1 .next will be 7.Then move head to dummy, so for next digit you change -1 to 4. for next digit insert 4. -1 - > 4 - > 7
you do not need to reverse the linked list.
you add the value and then basically you ar moving behind.
Then return head.next as you will have -1 at start additionally.


