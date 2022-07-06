/*
    想法：
        從左右兩邊找起
        要移動就挑比較低的移動

    兩個做法：用for和while
    for：速度較慢，但memory使用較少
    while：速度較快，但memory使用較多
 */

class Solution_MostWater {
    public int maxArea(int[] height) {
        int max_water = 0;
        int now_water = 0;
        int left = 0;
        int right = height.length-1;
        int width, high;

        
        for(int i = 0;i < height.length;i++){
            width = right - left;
            if(height[left] <= height[right]){
                high = height[left];
                now_water = width * high;
                left++;
            }
            else{
                high = height[right];
                now_water = width * high;
                right--;
            }

            if(now_water > max_water){
                max_water = now_water;
            }
        }

        /* 
        int i = 0;
        while(i < height.length){
            width = right - left;
            if(height[left] <= height[right]){
                high = height[left];
                now_water = width * high;
                left++;
            }
            else{
                high = height[right];
                now_water = width * high;
                right--;
            }

            if(now_water > max_water){
                max_water = now_water;
            }
            i++;
        }
        */

        return max_water;
        
    }
}


public class container_most_water{

    public static void main(String[] args) {
        Solution_MostWater test = new Solution_MostWater();

        int[] test_array = {1,8,6,2,5,4,8,3,7};

        int ans = test.maxArea(test_array);

        System.out.println(ans);
        
    }
}