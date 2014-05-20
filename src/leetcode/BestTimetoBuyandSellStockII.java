package leetcode;

/**
 * Created by anthony on 5/10/14.
 */
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            if(i+1 < prices.length && prices[i] < prices[i+1])
                profit += prices[i+1]-prices[i];
        }
        return profit;
    }
}
