class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left=0;
        long count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=minK && nums[i]<=maxK){
                count = count + i-left+1;
            }
            while(nums[i]<minK || nums[i]>maxK){
                left=i+1;
                break;
            }
        }
        return count;
    }
}