
class Solution {
    public String digitSum(String s, int k) {

        while(s.length() > k) {

            StringBuilder t = new StringBuilder();

            int sum = 0;
            int size = 0;

            for(int i = 0; i < s.length(); i++) {

                sum += s.charAt(i) - '0';
                size++;

                if(size == k || i == s.length() - 1) {
                    t.append(sum);
                    sum = 0;
                    size = 0;
                }
            }

            s = t.toString();
        }

        return s;
    }
}
