package leetcode;

/**
 * Created by anthony on 6/9/14.
 */
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int[] to_right = new int[prices.length];
        int[] from_left = new int[prices.length];

        int max = prices[prices.length-1];
        to_right[prices.length-1] = 0;
        for(int i = prices.length-2; i >= 0; i--){
            if(prices[i] > max)
                max = prices[i];
            to_right[i] = Math.max(max - prices[i], to_right[i+1]);
        }

        int min = prices[0];
        from_left[0] = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min)
                min = prices[i];
            from_left[i] = Math.max(prices[i] - min, from_left[i-1]);
        }
        int r = Math.max(from_left[prices.length-1], to_right[0]);
        for(int i = 1; i < prices.length; i++){
            int t = from_left[i-1]+to_right[i];
            if(t>r)
                r =t;
        }

        return r;
    }

    public int maxProfit_wrong(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int max = prices[0];
        int max1 = 0, max2 = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > max){
                max = prices[i];
            }
            else if(prices[i] < min){
                int t = max-min;
                if(t > max1){
                    max2 = max1;
                    max1 = t;
                }
                else if(t > max2){
                    max2 = t;
                }
                min = prices[i];
                max = prices[i];
            }
        }
        int t = max-min;
        if(t > max1){
            max2 = max1;
            max1 = t;
        }
        else if(t > max2){
            max2 = t;
        }

        return max1+max2;
    }

    public static void main(String args[]){
        //System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(new int[]{6,1,3,2,4,7}));
        System.out.println(new BestTimetoBuyandSellStockIII().maxProfit(new int[]{1}));
    }
}
