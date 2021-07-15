
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int copy[]  = new int [nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        copy = sorting(copy);
        
        int left,right;
        left = 0;
        right = copy.length - 1;
        while(copy[left] + copy[right] != target){
            if(copy[left] + copy[right] > target){
                right--;
            }
            else if(copy[left] + copy[right] < target){
                left++;
            }
        }
        
        int ans[] = new int [2];
        for(int i = 0;i < nums.length;i++){
            if(copy[left] == nums[i]){
                ans[0] = i;
            }
        }
        for(int i = nums.length - 1;i >= 0;i--){
            if(copy[right] == nums[i]){
                ans[1] = i;
            }
        }
        return ans;
    }
    
    public int[] sorting(int [] A){
        sort_040_2(A , 0 , A.length-1);
        
        return A;
    }

   
    private static int partition_040_2(int array [] , int low , int high){
        int i = low;
        int j = high + 1;
        while(true){
            while(less_040_2(array[++i] , array[low])){
                if(i == high){
                    break;
                }
            }

            while(less_040_2(array[low] , array[--j])){
                if(j == low){
                    break;
                }
            }

            if(i >= j){
                break;
            }

            exch_040_2(array , i , j);
        }

        exch_040_2(array , low , j);
        return j;
    }

    public static void sort_040_2(int [] array , int low , int high){
        
        if(high <= low + 9){
            insertion_040_2(array, low, high+1);
            return;
        }

        int j = partition_040_2(array , low , high);
        sort_040_2(array, low, j-1);
        sort_040_2(array, j+1, high);
    }

    private static void insertion_040_2(int [] array , int left , int right){
        for(int i = left;i < right;i++){
            for(int j = i;j > left;j--){
                if(less_040_2(array[j], array[j-1])){
                    exch_040_2(array, j, j-1);
                }
                else{
                    break;
                }
            }
        }
    }
    
    private static boolean less_040_2(int m , int n){
        if(m < n){
            return true;
        }
        else{
            return false;
        }
    }

    private static void exch_040_2(int [] array , int m , int n){
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}

public class two_sum{

    public static void main(String[] args) {
        Solution test = new Solution();
        int nums[] = {2,5,3,6,7,4,58,64,94};
        int ans[] = test.twoSum(nums, 12);
        System.out.println(ans[0] + "  " + ans[1]);
    }
}