class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int mini = Integer.MAX_VALUE;

        for(int i=0;i<nums.size();i++){
            int sum = 0;
            for(int j=i;j<nums.size();j++){
                sum = sum+nums.get(j);
                if(j-i+1 >=l && j-i+1<=r && sum>0){
                    mini = Math.min(mini,sum); 
                }

            }
        }
        if(mini==Integer.MAX_VALUE) return -1;
        return mini;
    }
}