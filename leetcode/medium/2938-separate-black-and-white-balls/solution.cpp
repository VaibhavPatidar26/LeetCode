class Solution {
public:
    long long minimumSteps(string s) {
        int p1=s.size()-1;
        int p2 = s.size()-1;
        long long counter =0;
        long long ans=0;
        for(int i=s.size()-1;i>=0;i--){
            if(s[i]=='0') counter++;
            else{
                ans = ans+counter;
            }
        }
        return ans;
    }
};