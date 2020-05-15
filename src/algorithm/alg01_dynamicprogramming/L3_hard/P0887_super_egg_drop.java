package algorithm.alg01_dynamicprogramming.L3_hard;

public class P0887_super_egg_drop {

    public static int superEggDrop(int K, int N) {

        int[][] memo = new int[K + 1][N + 1];

//         //没有楼层
//         for(int i = 0; i <= K; i++)
//             memo[i][0] = 0;

//         //没有鸡蛋
//         for(int i = 0; i <= N; i++)
//             memo[0][N] = 0;


        //仅有一个鸡蛋,随楼层增加
        for (int i = 1; i <= N; i++)
            memo[1][i] = i;

        //仅有一层楼,只扔一次
        for (int i = 1; i <= K; i++)
            memo[i][1] = 1;

        //初始化其他情况
        for (int i = 2; i <= K; i++)
            for (int j = 2; j <= N; j++)
                memo[i][j] = -1;

        return superEggDropMemo(K, N, memo);
    }

    public static int superEggDropMemo(int K, int N, int[][] memo) {

        if (K == 1) return N;

        if (N == 0) return 0;

        if (memo[K][N] != -1) return memo[K][N];

        int res = Integer.MAX_VALUE;

        //线性搜索最佳楼层
        //选出最少的情况
//        for (int i = 1; i <= N; i++) {
//            res = Math.min(res,
//                    //在第i层扔鸡蛋的最坏情况
//                    Math.max(
//                            superEggDropMemo(K - 1, i - 1, memo),  //鸡蛋在第i层碎了,剩余层数为 i-1
//                            superEggDropMemo(K, N - i, memo))  //鸡蛋在第i层没碎,剩余层数为 N-i
//                            + 1 //在第i层扔了一次鸡蛋
//            );
//        }

        //二分查找
        int low = 1, high = N;
        while (low <= high) {

            int mid = (low + high) / 2;

            int broken = superEggDropMemo(K - 1, mid - 1, memo);

            int not_broken = superEggDropMemo(K, N - mid, memo);

            if (broken > not_broken) {
                high = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                low = mid + 1;
                res = Math.min(res, not_broken + 1);
            }
        }


        memo[K][N] = res;

        return memo[K][N];
    }

    public static void main(String[] args) {

        System.out.println(superEggDrop(5, 10000));


    }
}
