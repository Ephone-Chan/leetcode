package lcof;

public class P12_ju_zhen_zhong_de_lu_jing {

    public static boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (hasPathCore(board, word, 0, row, col, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[][] board, String word, int index, int row, int col, boolean[][] visited) {

        if (index == word.length())
            return true;

        boolean res = false;

        if (row >= 0 && row < board.length &&
                col >= 0 && col < board[0].length &&
                !visited[row][col] &&
                board[row][col] == word.charAt(index)) {

            index++;

            visited[row][col] = true;

            boolean left = hasPathCore(board, word, index, row - 1, col, visited);
            boolean right = hasPathCore(board, word, index, row - 1, col, visited);
            boolean up = hasPathCore(board, word, index, row - 1, col, visited);
            boolean down = hasPathCore(board, word, index, row - 1, col, visited);

            res = left || right || up || down;

            if (!res)
                visited[row][col] = false;
        }
        return res;
    }

    public static void main(String[] args) {

        char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};


        exist(matrix,"ABCCED");

    }


}
