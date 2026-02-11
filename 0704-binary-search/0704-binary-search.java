import java.util.ArrayList;
class Solution {
    public int search(int[] nums, int target) {
         int upper=nums.length-1;
         int lower=0;
        while(lower<=upper)
        {
            int mid=(lower+upper)/2;
            if(nums[mid]==target)
            {
                System.out.println(mid);
                return mid;
                
            }
            else if(nums[mid]>target)
            {
                upper=mid-1;
            }
            else
            {
                lower=mid+1;
            }
        } return -1;
       
    }
    public static void main(String[]args)
    {
        int [] nums={-1,0,3,5,9,12};
        int target=9;
        Solution S = new Solution();
        S.search(nums,target);
    }
}