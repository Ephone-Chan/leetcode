package algorithm.alg01_dynamicprogramming.stockseries;

public class best_time_to_buy_and_sell_stock_iv {


    public static int maxProfit(int k, int[] prices) {

        if (prices.length == 0)
            return 0;

        int[][][] table = new int[prices.length + 1][k + 1][2];

        //初始状态
        //交易次数为 0，利润为 0
        for (int i = 0; i <= prices.length; i++)
            table[i][0][0] = 0;

        //初始状态
        //首次持有成本，无论交易多少次，首次持有股票的成本为第一天的价格
        for(int j = 1; j <=k; j++)
            table[0][j][1] = -prices[0];

        //穷举状态
        //天数
        for (int i = 1; i <= prices.length; i++) {
            //交易次数
            for (int j = 1; j <=k; j++) {

                //无股票
                //之前卖出 : table[i-1][j][0]
                //今天卖出 : table[i-1][j-1][1] + prices[i-1]
                table[i][j][0] = Math.max(table[i - 1][j][0], (table[i - 1][j][1] + prices[i - 1]));

                //有股票
                //之前购买 : table[i-1][j][1]
                //当天购买的 : table[i-1][j-1][0] - prices[i-1]
                table[i][j][1] = Math.max(table[i - 1][j][1], (table[i - 1][j - 1][0] - prices[i - 1]));
            }
        }
        return table[prices.length][k][0];
    }

    public static void main(String[] args) {

        int times = 1;

        int[] prices = new int[]{3,2,6,5,0,3,10};

        System.out.println(maxProfit(times, prices));
    }


}
