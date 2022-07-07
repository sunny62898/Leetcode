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
        由大單位表示到小單位
 */

class Solution_IntegerToRoman {
    int number = 0;
    public String intToRoman(int num) {
        number = num;
        String ans = "";
        ans += decrease(1000, "M");
        ans += decrease(900, "CM");
        ans += decrease(500, "D");
        ans += decrease(400, "CD");
        ans += decrease(100, "C");
        ans += decrease(90, "XC");
        ans += decrease(50, "L");
        ans += decrease(40, "XL");
        ans += decrease(10, "X");
        ans += decrease(9, "IX");
        ans += decrease(5, "V");
        ans += decrease(4, "IV");
        ans += decrease(1, "I");

        return ans;
        
    }
    private String decrease(int limit, String symbol){
        String str = "";
        while(number >= limit){
            str += symbol;
            number -= limit;
        }
        return str;
    }
}


public class integer_to_roman{

    public static void main(String[] args) {
        Solution_IntegerToRoman test = new Solution_IntegerToRoman();

        int test_number = 1994;

        String ans = test.intToRoman(test_number);

        System.out.println(ans);
        
    }
}