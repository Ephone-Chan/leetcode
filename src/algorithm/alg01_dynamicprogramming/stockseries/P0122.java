package algorithm.alg01_dynamicprogramming.stockseries;

public class P0122 {


    public int maxProfit(int[] prices) {

        int sum = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] > 0)
                sum += (prices[i + 1] - prices[i]);
        }

        return sum;
    }
}
