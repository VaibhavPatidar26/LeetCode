class Solution {
public:
    int countMagicalPairs(string s) {
       int ans=0;
        for(int i=0;i<s.length();i++){
            map<int,int>mp;
            map<char,bool>mpp;
            int dis =0;
            for(int j=i; j>=0;j--){
                if(!mpp.contains(s[j]))dis++;
                mpp[s[j]] = 1;
                mp[dis]++;
            }
            dis =0;
            mpp.clear();
            for(int j=i+1; j<s.length();j++){
                if(!mpp.contains(s[j]))dis++;
                mpp[s[j]] = 1;
                ans+=mp[dis];
            }
        }
        return ans;
       
    }
};