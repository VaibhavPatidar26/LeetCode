class Solution {

    public StringBuilder solve(int n) {
        if (n == 1) {
            return new StringBuilder("1");
        }

        StringBuilder prev = solve(n - 1);
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < prev.length();) {
            char ch = prev.charAt(i);
            int count = 0;

            while (i < prev.length() && prev.charAt(i) == ch) {
                count++;
                i++;
            }

            curr.append(count);
            curr.append(ch);
        }

        return curr;
    }

    public String countAndSay(int n) {
        return solve(n).toString();
    }
}