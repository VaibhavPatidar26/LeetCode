class Solution {
public:
    int minChanges(string s) {
        int count=0;
        stack<int>st;
        for(int i=0;i<s.size();i++){
            if(st.empty()){
                st.push(s[i]);//1
            }
            else{
                if(st.top()!=s[i]){
                    count++;
                    if(!st.empty()) st.pop(); 
                   
                }
                if(!st.empty()) st.pop(); 
            }
        }
        return count;
    }
};