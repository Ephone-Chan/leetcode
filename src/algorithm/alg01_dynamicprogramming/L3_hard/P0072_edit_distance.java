package algorithm.alg01_dynamicprogramming.L3_hard;

public class P0072_edit_distance {

    public static int minDistance(String word1, String word2) {

        int[][] memo = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++)
            memo[i][0] = i;

        for (int i = 0; i <= word2.length(); i++)
            memo[0][i] = i;

        for (int i = 1; i <= word1.length(); i++)
            for (int j = 1; j <= word2.length(); j++)
                memo[i][j] = Integer.MAX_VALUE;

        return minDis(word1, word2, word1.length() - 1, word2.length() - 1, memo);
    }

    private static int minDis(String s1, String s2, int i, int j, int[][] memo) {

        if (i == -1) return j + 1;

        if (j == -1) return i + 1;

        if (memo[i+1][j+1] < Integer.MAX_VALUE)
            return memo[i+1][j+1] ;

        //该位置字符相等无须操作
        if (s1.charAt(i) == s2.charAt(j))
            memo[i+1][j+1]  = minDis(s1, s2, i - 1, j - 1, memo);

        else
            memo[i+1][j+1]  = Math.min(Math.min(
                    minDis(s1, s2, i, j - 1, memo) + 1,       //s1增加字符,s2跳过当前位置
                    minDis(s1, s2, i - 1, j, memo) + 1),      //s1删除字符,s1跳过当前位置
                    minDis(s1, s2, i - 1, j - 1, memo) + 1);    //s1替换字符,s1 和 s2 共同往左走

        return memo[i+1][j+1] ;
    }

    public static void main(String[] args) {

        System.out.println(
                minDistance("horse", "ros"));

    }
}
