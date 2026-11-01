class Solution {
    public int minMergedInteger(int[] nums) {
        int mini = Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i=i+2){
            StringBuilder num1 = new StringBuilder(Integer.toString(nums[i-1]));
            StringBuilder num2 = new StringBuilder(Integer.toString(nums[i]));
            num1.append(num2);
            int ans = Integer.parseInt(num1.toString());
            mini = Math.min(mini,ans);
            
        }
        return mini;
    }
}