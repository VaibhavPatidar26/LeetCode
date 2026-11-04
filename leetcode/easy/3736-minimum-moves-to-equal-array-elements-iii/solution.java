class Solution {
    public int minMoves(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int count=0;
       for(int i=0;i<nums.length;i++){
            maxi = Math.max(maxi,nums[i]);
       }
       for(int i=0;i<nums.length;i++){
        count+=Math.abs((maxi-nums[i]));
       }
       return count;
    }
}