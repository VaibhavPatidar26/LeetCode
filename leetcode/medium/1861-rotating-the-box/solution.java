class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {

        for (int i = 0; i < boxGrid.length; i++) {
            int p1 = boxGrid[0].length - 1;

            for (int j = boxGrid[0].length - 1; j >= 0; j--) {

                if (boxGrid[i][j] == '#') {
                    char temp = boxGrid[i][p1];
                    boxGrid[i][p1] = boxGrid[i][j];
                    boxGrid[i][j] = temp;
                    p1--;
                }

                if (boxGrid[i][j] == '*') {
                    p1 = j - 1;
                }
            }
        }

        List<List<Character>> ans = new ArrayList<>();

        for (int i = 0; i < boxGrid[0].length; i++) {
            List<Character> current = new ArrayList<>();

            for (int j = boxGrid.length - 1; j >= 0; j--) {
                current.add(boxGrid[j][i]);
            }

            ans.add(current);
        }

        char[][] result = new char[ans.size()][ans.get(0).size()];

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                result[i][j] = ans.get(i).get(j);
            }
        }

        return result;
    }
}