class Solution {
    final int MOD = 1000000007;
    public long divisibleBy2(int[] arr,HashMap<Integer,Integer>mp){
        mp.put(0,mp.getOrDefault(0,0)+1);
        long count =0 ;
        int prefixSum = 0;
        for(int i=0;i<arr.length;i++){
            prefixSum+=arr[i];

            int rem = prefixSum % 2;
            if(rem<0){
                rem = rem + 2 ;
            }

            if(mp.containsKey(rem)){
                count = count+ mp.get(rem);
                mp.put(rem,mp.getOrDefault(rem,0)+1);
            }
            else{
                 mp.put(rem,mp.getOrDefault(rem,0)+1);
            }
        }
        return count;
    }

    public int numOfSubarrays(int[] arr) {
        //[1 3 5]
        //[1 4 9]
        //if i found no of subarrays divisible by 2 and substract that form total no of subarrays thats it.
        int n = arr.length;
        long total = (long)n * (n + 1) / 2;
        HashMap<Integer,Integer>mp = new HashMap<>();
        long evenSubarrays = divisibleBy2(arr, mp);

        return (int) ((total - evenSubarrays + MOD) % MOD);
    }
}