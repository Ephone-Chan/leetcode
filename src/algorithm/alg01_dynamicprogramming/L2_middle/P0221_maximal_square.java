package algorithm.alg01_dynamicprogramming.L2_middle;



public class P0221_maximal_square {

    public static int maximalSquare(char[][] matrix) {


        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;


        int row = matrix.length;

        int col = matrix[0].length;

        int[][] memo = new int[row + 1][col + 1];


        // 第 0 列
        for (int i = 0; i <= row; i++)
            memo[i][0] = 0;

        // 第 0 行
        for (int i = 1; i <= col; i++)
            memo[0][i] = 0;


        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '0')
                    memo[i][j] = 0;
                else
                    memo[i][j] = Math.min(memo[i - 1][j], Math.min(memo[i][j - 1], memo[i - 1][j - 1])) + 1;
            }
        }

        int max = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (memo[i][j] > max)
                    max = memo[i][j];
            }
        }

        return max * max;
    }


    public static void main(String[] args) {

        char[][] matrix =
                {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}};

        System.out.println(maximalSquare(matrix));

    }
}
