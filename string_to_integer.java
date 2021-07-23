class Solution_StringToInteger {
    public int myAtoi(String s) {
        /*if(s.length() == 0){
            return 0;
        }
        else if(s.length() >= 2 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
            if(s.charAt(0) == '-'){
                if(s.charAt(1) == '+' || s.charAt(1) == '-'){
                    return 0;
                }
            }
            else if(s.charAt(0) == '+'){
                if(s.charAt(1) == '+' || s.charAt(1) == '-'){
                    return 0;
                }
            }
        }

        if((s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') || (s.charAt(0) >= 'a' && s.charAt(0) <= 'z')){
            return 0;

        }
        else{
            boolean no = false;
            boolean plus = false;
            boolean neg = false;
            boolean charater = false;
            boolean zero = false;
            boolean Hnum = false;
            long num = 0;
            for(int i = 0;i < s.length();i++){
                char c = s.charAt(i);
                
                if(no && !(c >= '0' && c <= '9')){
                    return 0;
                }

                else if(Hnum && c == '-'){
                    break;
                }
                else if(plus && (c == ' ' || c == '+')){
                    return 0;
                }
                else if(zero && c == '-'){
                    return 0;
                }

                else if(i == 0 && c == '-'){
                    no = true;
                    neg = true;
                }
                else if(i != 0 && c == '-'){
                    no = true;
                    neg = true;
                }
                
                else if(c >= '0' && c <= '9'){
                    Hnum = true;
                    if(charater){
                        break;
                    }
                    if(c == '0'){
                        zero = true;
                    }
                    num = num*10 + (c - '0');
                    
                    if(num > Integer.MAX_VALUE){
                        
                        if(neg){
                            return Integer.MIN_VALUE;
                        }
                        else{
                            
                            return Integer.MAX_VALUE;
                        }
                        
                    }
                    
                }
                else if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                    charater = true;
                }
                else{
                    if(Hnum){
                        break;
                    }
                    else if(c == ' ' || c == '+'){
                        no = true;
                        if(c == '+'){
                            plus = true;
                        }
                        continue;
                    }
                    else{
                        break;
                    }
                    
                }
            }
            if(neg){
                return (-1)*(int)num;
            }
            else{
                
                return (int)num;
            }
            
        }*/



        final int len = s.length();
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
    
    }
}



public class string_to_integer {
    public static void main(String[] args) {
        Solution_StringToInteger test = new Solution_StringToInteger();
        
        String str = "++1";
        int ans = test.myAtoi(str);
        System.out.println(ans);
    }
}
