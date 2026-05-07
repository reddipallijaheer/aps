class Solution {
    public void moveZeroes(int[] nums) {
        int unique=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!= 0){
                int temp = nums[unique];
                nums[unique]=nums[i];
                nums[i]=temp;
                unique++;
            }
        }
    }
}