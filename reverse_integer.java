class Solution_ReverseInteger {
    public int reverse(int x) {
        
        long sum = 0;
        if(x < 0){
            x = Math.abs(x);
            while(x > 0){
                sum = sum * 10 + (x % 10);
                x = x / 10;
            }
            if(sum > Integer.MAX_VALUE){
                return 0;
            }
            else{
                return (-1)*(int)sum;
            }
            
        }
        else{
            while(x > 0){
                sum = sum * 10 + (x % 10);
                x = x / 10;
            }
            if(sum > Integer.MAX_VALUE){
                return 0;
            }
            else{
                return (int)sum;
            }
            
        }
    }
}


public class reverse_integer {
    public static void main(String[] args) {
        Solution_ReverseInteger test = new Solution_ReverseInteger();
        int ans = test.reverse(1534236469);
        System.out.println(ans);
    }
}
