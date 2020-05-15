package lcof;

public class P14_jian_sheng_zi {

    public static int cuttingRope(int n) {

        if (n <= 1)
            return 1;

        int[] memo = new int[n + 1];

        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            int max = -1;
            for (int j = 1; j <= i / 2; j++) {
                //对于两个数，拆分与不拆分，共有 4 种组合情况
                int temp = getMax((i - j) * j, memo[i - j] * j, (i - j) * memo[j], memo[i - j] * memo[j]);
                if (temp > max)
                    max = temp;
            }
            memo[i] = max;
        }

        return memo[n];
    }

    public static int getMax(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }


    public static int cuttingRope_greedy(int n) {

        if (n <= 2)
            return 1;

        if (n == 3)
            return 2;

        int countOf3 = n / 3;

        if (n - countOf3 * 3 == 1)
            countOf3 -= 1;

        int countOf2 = (n - (countOf3 * 3)) / 2;

        return (int) (Math.pow(3, countOf3) * Math.pow(2, countOf2));

    }


    public static void main(String[] args) {

        System.out.println(cuttingRope_greedy(10));

    }

}
