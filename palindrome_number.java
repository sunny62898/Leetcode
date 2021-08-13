class Solution_palindrome_number {
    public boolean isPalindrome(int x) {
        if(x >= 0 && x < 10){
            return true;
        }
        else if(x < 0){
            return false;
        }
        
        String str = Integer.toString(x);
    
        for(int left = 0, right = str.length()-1;left < str.length()/2;left++, right--){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
        }
        return true;
        
        
    }
}




public class palindrome_number {
    
    public static void main(String[] args) {
        Solution_palindrome_number test = new Solution_palindrome_number();
        int num = 102201;
        boolean ans = test.isPalindrome(num);
        System.out.println(ans);
    }
}
