class Solution_LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0){
            return 0;
        }
        
        int now = 1;
        boolean testSame = false;
        int max = 1;
        int j = 0;
        int nownum = 0;
        for(int i = 1;i < s.length();i++){
            nownum = 0;
            testSame = false;
            j = i - 1;
            while(nownum < now){
                nownum++;
                if(Character.compare(s.charAt(j), s.charAt(i)) == 0){
                    
                    testSame = true;
                    break;
                }
                j--;
            }

            if(testSame){
                now = nownum;
            }
            else{
                now++;
            }
            
            if(now > max){
                max = now;
            }

            
        }

        return max;
        
    }


}

public class longest_substring {
    public static void main(String[] args) {
        Solution_LongestSubstring test = new Solution_LongestSubstring();
        String str = "qqqqqqq";
        int ans = test.lengthOfLongestSubstring(str);
        System.out.println(ans);
    }
}
