class Solution_StringToInteger {
    public int myAtoi(String s) {

        /*final int len = s.length();
        if(len < 1) return 0;
        
        int i = 0, ret = 0;
        boolean sign = true; // true -> positive, false -> negative
        final int MAX = Integer.MAX_VALUE; // cache to avoid O(n) library calls
        final int MIN = Integer.MIN_VALUE;
        
        // move to the first non white space character
        while(i < len && s.charAt(i) == ' ') i++;
        if(i == len) return 0;
        
        // check the sign
        char c = s.charAt(i);
        if(c == '-' || c == '+')
            sign = (s.charAt(i++) == '+') ? true : false;
        
        for(; i<len; i++){
            c = s.charAt(i);

            // make sure c is a digit
            if(c < '0' || c > '9') break;

            if(sign){
                if(ret > (MAX - (c-'0'))/10) return MAX;
                ret = ret*10 + (c-'0');
            }
            else {
                if(ret < (MIN + (c-'0'))/10) return MIN;
                ret = ret*10 - (c-'0');
            }
        }
              
        return ret;
    */

        int i = 0;
        while(i < s.length() && s.charAt(i) == ' '){  //讀掉前面的空白
            i++;
        }

        long sum = 0;
        boolean neg = false;
        boolean pos = false;
        boolean num = false;
        for(int j = i;j < s.length();j++){
            if(s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                num = true;
                sum = sum*10 + (s.charAt(j) - '0');
                if(sum > Integer.MAX_VALUE){
                    if(neg){
                        return Integer.MIN_VALUE;
                    }
                    else{
                        return Integer.MAX_VALUE;
                    }
                }
            }
            else if(neg || pos){
                if(sum > Integer.MAX_VALUE){
                    if(neg){
                        return Integer.MIN_VALUE;
                    }
                    else{
                        return Integer.MAX_VALUE;
                    }
                }
                else{
                    if(neg){
                        return (-1)*(int)(sum);
                    }
                    else{
                        return (int)(sum);
                    }
                }
            }
            else if(!num && s.charAt(j) == '-'){
                neg = true;
            }
            else if(!pos && s.charAt(j) == '+'){
                pos = true;
            }
            
            else{
                if(sum > Integer.MAX_VALUE){
                    if(neg){
                        return Integer.MIN_VALUE;
                    }
                    else{
                        return Integer.MAX_VALUE;
                    }
                }
                else{
                    if(neg){
                        return (-1)*(int)(sum);
                    }
                    else{
                        return (int)(sum);
                    }
                }
                
            }
        }
       
        if(neg){
            return (-1)*(int)(sum);
        }
        else{
            return (int)(sum);
        }
    }
}



public class string_to_integer {
    public static void main(String[] args) {
        Solution_StringToInteger test = new Solution_StringToInteger();
        
        String str = "9223372036854775808";
        int ans = test.myAtoi(str);
        System.out.println(ans);
    }
}
