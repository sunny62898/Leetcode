class Solution_StringToInteger {
    public int myAtoi(String s) {
        if(s.length() == 0){
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
            boolean neg = false;
            long num = 0;
            for(int i = 0;i < s.length();i++){
                char c = s.charAt(i);
                
                if(c == '-'){
                    neg = true;
                }
                else if(i == 0 && c == '0'){
                    return 0;
                }
                else if(c >= '0' && c <= '9'){
                    num = num*10 + (c - '0');
                    
                    if(num >= Integer.MAX_VALUE){
                        
                        if(neg){
                            return Integer.MIN_VALUE;
                        }
                        else{
                            
                            return Integer.MAX_VALUE;
                        }
                        
                    }
                    
                }
                else{
                    if(c == ' ' || c == '+'){
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
            
        }
    }
}



public class string_to_integer {
    public static void main(String[] args) {
        Solution_StringToInteger test = new Solution_StringToInteger();
        String str = "21474836460";
        int ans = test.myAtoi(str);
        System.out.println(ans);
    }
}
