class Solution_ZigZag_conversion {
    public String convert(String s, int numRows) {
        /*
            solution
            字串的轉換是按照順序的
            所以用index來排
            假如numRows = 4
            row(0) : index(0), index(6), index(6), index(12), index(12)...
            row(1) : index(1), index(5), index(7), index(11), index(13)...
            row(2) : index(2), index(4), index(8), index(10), index(14)...
            row(3) : index(3), index(3), index(9), index(9),  index(15)...
            這樣我們會發現相鄰兩行所加起來來的數字相同
            ex: 0+6 = 1+5 = 2+4 = 3+3 = 6  = 1*6 
                6+6 = 5+7 = 4+8 + 3+9 = 12 = 2*6
                6+12 = 7+11 = 8+10 = 9+9 = 18 = 3*6
            以此類推會發現皆會是6的倍數
            所以可推得2*(numRows - 1)這個公式
            ex: 2*(4-1) = 6

            ps: 假如numRows = 1那就直接回傳string
                for(來定義每個row的第一個字index)
                    for(來運算要填入哪個字, 從第二個字開始填)
            
        */
        if(s.length() <= numRows || numRows == 1){
            return s;
        }

        StringBuilder string = new StringBuilder();
        int index = 0;
        int n = 0;
        for(int i = 0;i < numRows;i++){
            string.append(s.charAt(i));
            n = i;
            index = 2*(numRows - 1)-n;
            for(int j = 1;index < s.length();j++, n = index, index = 2*j*(numRows - 1)-n){
                if(index > n){
                    string.append(s.charAt(index));
                }
                
            }
        }


        return string.toString();
    }
}


public class ZigZag_conversion{

    public static void main(String[] args) {
        Solution_ZigZag_conversion test = new Solution_ZigZag_conversion();
        String s = "PAYPALISHIRING";
        String ans = test.convert(s, 4);
        System.out.println(ans);
    }
}