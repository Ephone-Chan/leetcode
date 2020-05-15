package algorithm.alg01_dynamicprogramming.stockseries;

public class best_time_to_buy_and_sell_stock_dp {


    public static int stock_i_dp(int[] prices) {
        if (prices.length == 0)
            return 0;

        int[][][] table = new int[prices.length + 1][1 + 1][2];

        //初始状态
        for (int i = 0; i <= prices.length; i++) {

            //交易次数为 0，利润为 0
            table[i][0][0] = 0;

            //无交易拥有股票，不可能状态
            //考虑到第一次在 i 买入股票时，最小利润为 -prices[i]，因 table取[i-1][0][0] 为 0，即买入股票利润为 -prices[i]
            // -prices[i] 与 table取[i-1][0][0] - prices[i] 一致，故 table[i-1][0][1] 取 -prices[i] 即可
            table[i][0][1] = Integer.MIN_VALUE;
        }

        //首次操作持有股票的成本
        table[0][1][1] = -prices[0];

        //穷举状态

        //天数
        for (int i = 1; i <= prices.length; i++) {
            //交易次数
            for (int j = 1; j <= 1; j++) {

                //无股票
                table[i][j][0] = Math.max(table[i - 1][j][0], (table[i - 1][j][1] + prices[i - 1]));

                //有股票
                table[i][j][1] = Math.max(table[i - 1][j][1], (table[i - 1][j - 1][0] - prices[i - 1]));
            }
        }
        return table[prices.length][1][0];
    }
}
