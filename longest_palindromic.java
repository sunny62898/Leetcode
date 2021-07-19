class Solution_LongestPalindromic {
    public String longestPalindrome(String s) {
        
        int len1 = 0;
        int len2 = 0;
        int len = 0;
        int max = 0;
        int start = 0;
        int end = 0;

        for(int i = 0;i < s.length()-1;i++){

            //i值當作中間 然後由中間向外尋找有無回文

            len1 = center(s, i, i);  //中間值都為i 代表這個回文為單數
            len2 = center(s, i, i+1);  //由i和i+1開始找 代表回文為雙數

            len = Math.max(len1, len2);
            if(len > max){
                max = len;
                start = i - (len-1)/2;
                end = i + (len/2);

            }

        }
        return s.substring(start, end+1);   //substring(start , end)  end為輸出到end-1
        
    }

    int center(String s, int left, int right){
        
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
        

        
}


public class longest_palindromic {
    public static void main(String[] args) {
        Solution_LongestPalindromic test = new Solution_LongestPalindromic();
        String str = "abcabcac";
        String ans = test.longestPalindrome(str);
        System.out.println(ans);
    }
}
