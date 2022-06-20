package tx;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        int[][] f = new int[length1 + 1][length2 + 1];
        //
        for (int i = 0; i < f.length; i++) {
            f[i][0] = 0;
        }
        for (int j = 0; j < f[0].length; j++) {
            f[0][j] = 0;
        }

        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[0].length; j++) {
                f[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? f[i - 1][j - 1] + 1 : Math.max(f[i - 1][j], f[i][j - 1]);
            }
        }

        return f[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
    }
}
