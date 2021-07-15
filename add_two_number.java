

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode rear = ans;
        boolean ten = false;
        int l1Val = l1.val;
        int l2Val = l2.val;
        int sum = 0;
        while((l1 != null || l2 != null) || ten){
            
            if(l1 == null && l2 == null && ten){
                rear.val = 1;
                return ans;
            }

            else if(l1 == null && l2 == null && !ten){
                rear.val = 0;
                return ans;
            }
            
            else if(ten){
                
                sum = 1 + l1Val + l2Val;
            }
            else{
                sum = l1Val + l2Val;
            }

            ten = false;

            if(sum >= 10){
                rear.val = sum % 10;
                ten = true;
            }
            else{
                rear.val = sum;
            }

            if(l1 != null && l2 != null){
                l1 = l1.next;
                l2 = l2.next;

                if(l1 == null){
                    l1Val = 0;
                }
                else{
                    l1Val = l1.val;
                }
                if(l2 == null){
                    l2Val = 0;
                }
                else{
                    l2Val = l2.val;
                }
                
                
            }

            else if(l1 != null && l2 == null){
                l1 = l1.next;
                if(l1 == null){
                    l1Val = 0;
                }
                else{
                    l1Val = l1.val;
                }

                l2Val = 0;
            }

            else if(l1 == null && l2 != null){
                l2 = l2.next;
                if(l2 == null){
                    l2Val = 0;
                }
                else{
                    l2Val = l2.val;
                }

                l1Val = 0;
            }

            else{
                l1Val = 0;
                l2Val = 0;
            }
            
            if((l1 != null || l2 != null) || ten){
                rear.next = new ListNode();
                rear = rear.next;
            }
            
        }

        
        return ans;
    }

    
}

class ListNode {
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


public class add_two_number{

    public static void main(String[] args) {
        Solution test = new Solution();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode l1H = l1;
        ListNode l2H = l2;

        l1H.val = 2;
        l2H.val = 5;

        l1H.next = new ListNode(0);
        l2H.next = new ListNode(0);
        l1H = l1H.next;
        l2H = l2H.next;

        l1H.val = 4;
        l2H.val = 6;

        l1H.next = new ListNode(0);
        l2H.next = new ListNode(0);
        l1H = l1H.next;
        l2H = l2H.next;

        l1H.val = 3;
        l2H.val = 4;

    
        ListNode ans =  test.addTwoNumbers(l1, l2);
        ListNode rear = ans;

        while(rear != null){
            System.out.print("\na = " + rear.val);
            rear = rear.next;
        }
        
    }
}