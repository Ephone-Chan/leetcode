package algorithm.alg01_dynamicprogramming.stockseries;

public class P0121 {


    public int maxProfit(int[] prices) {

        if (prices.length == 0)
            return 0;

        int minPrice = prices[0];   //第一天作为最小值,哨兵位

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > profit)
                profit = prices[i] - minPrice;

            if (prices[i] < minPrice)
                minPrice = prices[i];
        }

        return profit;
    }

}
