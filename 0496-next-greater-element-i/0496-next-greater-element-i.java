class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int t = 0; t < nums1.length; t++){

            int num1Current = nums1[t];
            int index = -1;
            for(int i = 0; i < nums2.length; i++){
                int curr = nums2[i];
                if(curr == num1Current){
                    index = i;
                    break;
                }
            }

            int ans = -1;
            for(int i = index + 1; i < nums2.length; i++){
                if(num1Current < nums2[i]){
                    ans = nums2[i];
                    break;
                }
            }
            list.add(ans);
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }
}