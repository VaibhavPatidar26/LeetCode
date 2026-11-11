
class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;

        Deque<ListNode> dq = new ArrayDeque<>();

        ListNode temp = head;

        while(temp != null) {
            dq.addLast(temp);
            temp = temp.next;
        }

       
        dq.removeFirst();

        temp = head;

        while(!dq.isEmpty()) {

           
            temp.next = dq.removeLast();
            temp = temp.next;

            
            if(!dq.isEmpty()) {
                temp.next = dq.removeFirst();
                temp = temp.next;
            }
        }

        
        temp.next = null;
    }
}
