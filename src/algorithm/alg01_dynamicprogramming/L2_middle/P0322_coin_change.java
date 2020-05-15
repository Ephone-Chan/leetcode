package algorithm.alg01_dynamicprogramming.L2_middle;

public class P0322_coin_change {


    /*
        凑硬币，经典的 dp 题目
     */

    public static int coinChange(int[] coins, int amount) {

        if(coins == null || coins.length == 0)
            return -1;

        if(amount == 0)
            return 0;

        int[] value = new int[amount + 1];

        for(int i = 1; i <= amount; i++){

            int min = Integer.MAX_VALUE;

            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && value[i - coins[j]] != -1){
                    min = Math.min(min, value[i-coins[j]] + 1);
                }
            }

            if(min == Integer.MAX_VALUE)
                value[i] = -1;
            else
                value[i] = min;
        }

        return value[amount];
    }


    public static void main(String[] args){

        System.out.println(coinChange(new int[]{2}, 3));
    }
}
