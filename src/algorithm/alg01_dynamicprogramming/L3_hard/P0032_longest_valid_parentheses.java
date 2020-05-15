package algorithm.alg01_dynamicprogramming.L3_hard;

public class P0032_longest_valid_parentheses {

    public static int longestValidParentheses(String s) {

        int[] dp = new int[s.length()+1];

        dp[0] = 0;

        for(int i = 2; i <= s.length(); i++){

            // () 的情形
            if(s.charAt(i-1) == ')' && s.charAt(i-2) == '(')
                dp[i] = dp[i-2] + 2;

            // )) 的情形
            if(s.charAt(i-1) == ')' && s.charAt(i-2) == ')'){
                // i-1 回到前一位, 再-algorithm.dp[i-1] 回到前一个 ) 的 ( 之前一位,因为dp数组比字符串多一位,所以要再-1
                if(i-1-dp[i-1]-1 >= 0 && s.charAt(i-1-dp[i-1]-1) == '(')
                    dp[i] = dp[i-1] + 2 + dp[i-1-dp[i-1]-1];    // algorithm.dp[i-1-algorithm.dp[i-1]-1-1]当前 ) 所匹配的 ( 的前一个的最长连续有效长度
            }
        }

        int max = 0;

        for(int i = 0; i <= s.length(); i++)
            max = max > dp[i] ? max : dp[i];

        return max;
    }


    public static void main(String[] args) {

        System.out.println(P0032_longest_valid_parentheses.longestValidParentheses("()(())"));

    }
}
