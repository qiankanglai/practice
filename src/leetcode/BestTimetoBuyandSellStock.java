package leetcode;

/**
 * Created by anthony on 5/10/14.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int min = prices[0], maxprofit = 0;
        for(int i = 0; i < prices.length; i++){
            int p = prices[i] - min;
            if(p > maxprofit)
                maxprofit = p;
            if(prices[i] < min)
                min = prices[i];
        }
        return maxprofit;
    }
}
