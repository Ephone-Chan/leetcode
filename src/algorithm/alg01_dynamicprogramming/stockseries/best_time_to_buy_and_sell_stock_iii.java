package algorithm.alg01_dynamicprogramming.stockseries;

public class best_time_to_buy_and_sell_stock_iii {


    /*
    动态规划：最大利润取决于两次交易利润之和，两次交易安排在两个时间段，则最大利润取决于 不同切分时间段的交易利润和 的最大值
    切分：第一次交易为 prices[0,i] ，则第二次交易为 prices[i ~ n-1]；
    最大值：max( price[0,i] + )
    每个时间点都有对于该点的最大利润，该点的最大利润取决于 前一点最大利润 与 当前时间点发生交易产生利润的最大值 两者当中的最大值
     */

    public int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;


        int[] firstTrade = new int[prices.length];
        firstTrade[0] = 0;

        int[] secondTrade = new int[prices.length];
        secondTrade[prices.length - 1] = 0;

        //第一次交易最小买入价格   /   第二次交易最大卖出价格
        int firstMin = prices[0], secondMax = prices[prices.length - 1];


        for (int i = 1; i <= prices.length - 1; i++) {

            //各个时间点做第一次交易的最大利润，卖出范围右侧扩大
            //卖出价格变化，若卖出价格变大，则当前点的利润较左侧点上升
            if (prices[i] < firstMin)
                firstMin = prices[i];
            if (prices[i] - firstMin > firstTrade[i - 1])
                firstTrade[i] = prices[i] - firstMin;
            else
                firstTrade[i] = prices[i] - firstMin;

            //各个时间点做第二次交易的最大利润，买入范围向左侧扩大
            //买入价格变化，若买入价格变小，则当前点的利润较右侧点上升
            if (prices[prices.length - 1 - i] > secondMax)
                secondMax = prices[prices.length - 1 - i];
            if (secondMax - prices[prices.length - 1 - i] > secondTrade[prices.length - i])
                secondTrade[prices.length - 1 - i] = secondMax - prices[prices.length - 1 - i];
            else
                secondTrade[prices.length - 1 - i] = secondTrade[prices.length - i];
        }

        int sum = 0;

        //取不同交易划分段之和的最大值
        for (int i = 0; i <= prices.length - 1; i++) {
            if (sum < firstTrade[i] + secondTrade[i])
                sum = firstTrade[i] + secondTrade[i];
        }

        return sum;
    }


    public static void main(String[] args) {

        best_time_to_buy_and_sell_stock_iii s = new best_time_to_buy_and_sell_stock_iii();

        System.out.println(s.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));

    }
}
