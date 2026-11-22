class Solution {
    public boolean checkString(String s) {
        Stack<Character>st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' && !st.isEmpty() && st.peek()=='b'){
                return false;
            }
            st.push(s.charAt(i));

        }
        return true;
    }
}