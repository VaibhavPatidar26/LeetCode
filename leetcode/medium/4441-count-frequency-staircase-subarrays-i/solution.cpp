class Solution {
public:
    int countStaircase(vector<int>& nums) {
      int ans=0;
       for(int i=0;i<nums.size();i++){
             unordered_map<int,int>mp;
           vector<int>store;
        for(int j=i;j<nums.size();j++){
            mp[nums[j]]++;
            if(mp[nums[j]]==1) store.push_back(nums[j]);
            int x=0;
            bool flag = true;
            for(int k=0;k<store.size();k++){
                if(mp[store[k]]!=x+1){
                    flag = false;
                    break;
                    
                }else{
                    x++;
                }
            }
            if(flag)ans++;
        }
       }
        return ans;
    }
};