package lcci;

public class P0107_rotate_matrix {

//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],

    public static void rotate(int[][] matrix) {

        //图像层数
        for (int i = 0; i < matrix.length / 2; i++) {

            //每层元素个数
            for (int j = i; j < matrix.length - i - 1; j++) {

                int temp = matrix[j][matrix.length - 1 - i];        // 11 暂存,(n行末列,暂存), 末列,沿着行数变动

                matrix[j][matrix.length - 1 - i] = matrix[i][j];    // 5 -> 11,(首行n列 -> n行末列),  末列,沿着行变动 = 首行,沿着列变动

                matrix[i][j] = matrix[matrix.length - 1 - j][i];    // 15 -> 5,(n行首列 -> 首行首列), 首行,沿着列变动 = 首列,沿着行变动

                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];   // 16 -> 15,(n行末列 -> n行首列), 首列,沿着行变动 = 末行,沿着列变动

                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = temp;   // 11 -> 16,(首行n列->n行末列), 末列,沿着行变动

                System.out.println(j + ":");

                printMatrix(matrix);
            }
        }
    }


    public static void printMatrix(int[][] matrix) {


        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println();

        }

    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("raw: ");

        printMatrix(matrix);

        rotate(matrix);
    }
}
