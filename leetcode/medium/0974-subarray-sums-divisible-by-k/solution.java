class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];

            int rem = prefixSum%k;
            if(rem<0){
                rem = rem+k;
            }
            if(mp.containsKey(rem)){
                count += mp.get(rem);
                mp.put(rem,mp.getOrDefault(rem,0)+1);
            }else{
                 mp.put(rem,mp.getOrDefault(rem,0)+1);
            }
        }
        return count;
    }
}