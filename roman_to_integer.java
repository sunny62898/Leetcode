/*
    符號表：
        Symbol       Value
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

    特殊符號：
        IV = 4,     IX = 9
        XL = 40,    XC = 90
        CD = 400,   CM = 900

    想法：
        由大單位轉換到小單位
 */

class Solution_RomanToInteger {
    public int romanToInt(String s) {
        int ans = 0;

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'I'){
                if(i+1 < s.length()){
                    if(s.charAt(i+1) == 'V'){
                        i += 1;
                        ans += 4;
                    }
                    else if(s.charAt(i+1) == 'X'){
                        i += 1;
                        ans += 9;
                    }
                    else{
                        ans += 1;
                    }
                }
                else{
                    ans += 1;
                }
            }

            else if(s.charAt(i) == 'X'){
                if(i+1 < s.length()){
                    if(s.charAt(i+1) == 'L'){
                        i += 1;
                        ans += 40;
                    }
                    else if(s.charAt(i+1) == 'C'){
                        i += 1;
                        ans += 90;
                    }
                    else{
                        ans += 10;
                    }
                }
                else{
                    ans += 10;
                }
            }

            else if(s.charAt(i) == 'C'){
                if(i+1 < s.length()){
                    if(s.charAt(i+1) == 'D'){
                        i += 1;
                        ans += 400;
                    }
                    else if(s.charAt(i+1) == 'M'){
                        i += 1;
                        ans += 900;
                    }
                    else{
                        ans += 100;
                    }
                }
                else{
                    ans += 100;
                }
            }

            else if(s.charAt(i) == 'V'){
                ans += 5;
            }
            else if(s.charAt(i) == 'L'){
                ans += 50;
            }
            else if(s.charAt(i) == 'D'){
                ans += 500;
            }
            else if(s.charAt(i) == 'M'){
                ans += 1000;
            }
        }

        return ans;
    }

    
}


public class roman_to_integer{

    public static void main(String[] args) {
        Solution_RomanToInteger test = new Solution_RomanToInteger();

        String test_str = "MCMXCIV";

        int ans = test.romanToInt(test_str);

        System.out.println(ans);
        
    }
}