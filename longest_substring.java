import java.util.HashSet;
import java.util.Set;

class Solution_LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        

        /*
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
        */


        Set <Character> seen = new HashSet<>();
        int i  = 0;
        int max = 0;
        
        for(int j = 0; j < s.length();j++){
            char c = s.charAt(j);

            while(seen.contains(c)){   //刪到c的時候才會停下來
                
                seen.remove(s.charAt(i++)); //否則一直從前面刪過來

            }

            seen.add(c);   //加上新加入的c
            max = Math.max(max, j - i + 1);
        }

        return max;
    }


}

public class longest_substring {
    public static void main(String[] args) {
        Solution_LongestSubstring test = new Solution_LongestSubstring();
        String str = "abbcabcaa";
        int ans = test.lengthOfLongestSubstring(str);
        System.out.println(ans);
    }
}
