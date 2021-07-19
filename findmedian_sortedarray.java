

class Solution_findMedianSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0;
        }
        else if(nums1 == null){
            if(nums2.length == 1){
                return nums2[0];
            }
            else if(nums2.length % 2 == 0){ //雙數
                return (nums2[nums2.length/2] + nums2[(nums2.length/2)-1])/2;
            }
            else{  //單數
                return nums2[nums2.length/2];

            }
        }

        else if(nums2 == null){
            if(nums1.length == 1){
                return nums1[0];
            }
            else if(nums1.length % 2 == 0){ //雙數
                return (nums1[nums1.length/2] + nums1[(nums1.length/2)-1])/2;
            }
            else{  //單數
                return nums1[nums1.length/2];

            }
        }

        else{
            int [] combine = new int [nums1.length + nums2.length];
            System.arraycopy(nums1, 0, combine, 0, nums1.length);
            System.arraycopy(nums2, 0, combine, nums1.length, nums2.length);

            insertionsort(combine);

            if(combine.length % 2 == 0){ //雙數

                return ((float)combine[combine.length/2] + (float)combine[(combine.length/2)-1])/2;
            }
            else{  //單數
                return (float)combine[combine.length/2];

            }
            
        }
    }

    void insertionsort(int [] array){
        int len = array.length;
        int key,j;
        for(int i = 0;i < len;i++){
            key = array[i];
            j = i - 1;
            while(j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = key;
        }
    }
}





public class findmedian_sortedarray {
    public static void main(String[] args) {
        Solution_findMedianSortedArray test = new Solution_findMedianSortedArray();
        int nums1[] = {2,5,6,7,64,94};
        int nums2[] = {1,2,3,4,5,6,7,89};
        double ans = test.findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }
}
