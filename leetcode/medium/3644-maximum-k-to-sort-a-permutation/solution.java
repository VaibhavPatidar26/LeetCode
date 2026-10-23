class Solution {
    public int sortPermutation(int[] nums) {
        int temp =-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                temp = temp&nums[i];
            }
        }
        if(temp==-1)return 0;
        else return temp;
    }
}