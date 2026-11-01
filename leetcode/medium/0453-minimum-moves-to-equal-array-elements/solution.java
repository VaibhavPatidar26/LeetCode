class Solution {
    public int minMoves(int[] nums) {
       int maxi = Integer.MIN_VALUE;
       int mini = Integer.MAX_VALUE;
       int sum=0;
       for(int i=0;i<nums.length;i++){
        maxi = Math.max(nums[i],maxi);
        mini = Math.min(nums[i],mini);
        sum +=nums[i];
       }

       if(maxi==mini) return 0;
      
       
       
            return sum - (mini*nums.length);
       

    }
}