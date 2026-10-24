class Solution {
    public int peakValleyDifference(int[] nums) {
        List<Integer>peaks = new ArrayList<>();
        List<Integer>valleys = new ArrayList<>();
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i+1] && nums[i]>nums[i-1]){
                peaks.add(nums[i]);
            }
            else if(nums[i]<nums[i+1] && nums[i]<nums[i-1]){
                valleys.add(nums[i]);
            }
        }
        int peakSum=0;
        int valleySum=0;
        for(int i=0;i<peaks.size();i++){
            peakSum+=peaks.get(i);
        }
        for(int i=0;i<valleys.size();i++){
            valleySum+=valleys.get(i);
        }
        return peakSum-valleySum;
    }
}