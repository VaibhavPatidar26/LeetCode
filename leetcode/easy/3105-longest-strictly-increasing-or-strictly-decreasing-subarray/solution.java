
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = 1;

        for(int i = 0; i < nums.length; i++) {
            boolean increasing = true;
            boolean decreasing = true;

            for(int j = i + 1; j < nums.length; j++) {

                if(nums[j-1] < nums[j]) {
                    decreasing = false;
                }
                else if(nums[j-1] > nums[j]) {
                    increasing = false;
                }
                else {
                    break;
                }

                if(increasing || decreasing) {
                    int currlen = j - i + 1;
                    len = Math.max(len, currlen);
                }
                else {
                    break;
                }
            }
        }

        return len;
    }
}
