class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        //1 2 9 10->1+0+7+8
        int median =0;
        if(nums.length%2==0){
            median = nums[(nums.length/2) - 1];
        }else{
            median = nums[nums.length/2];
        }

        for(int i=0;i<nums.length;i++){
            count += Math.abs(nums[i]-median);
        }
        return count;

    }
}