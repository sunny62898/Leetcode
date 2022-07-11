/*
    尋找最長的相同開頭字

    想法：
        比對開頭字，如果不正確 "break"
 */

class Solution_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if(strs.length == 1){
            ans = strs[0];
            return ans;
        }

        //find shortest word length
        int shortlength = 1000;
        for(int i = 0;i < strs.length;i++){
            if(strs[i].length() < shortlength){
                shortlength = strs[i].length();
            }
        }

        //find answer string
        Boolean same = false;
        for(int i = 0;i < shortlength;i++){     //word compare
            for(int j = 0;j < strs.length-1;j++){
                if(strs[j].charAt(i) == strs[j+1].charAt(i)){
                    same = true;
                }
                else{
                    same = false;
                    break;
                }
            }

            if(same){
                ans += strs[0].charAt(i);
            }
            else{
                break;
            }
        }

        return ans;
    }

    
}


public class longest_common_prefix{

    public static void main(String[] args) {
        Solution_LongestCommonPrefix test = new Solution_LongestCommonPrefix();

        String [] test_str = {"dog","racecar","car"};

        String ans = test.longestCommonPrefix(test_str);

        System.out.println(ans);
        
    }
}