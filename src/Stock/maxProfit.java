package Stock;

/*
    QUESTION:

    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/


/*
    SOLUTION:
        TLDR:
            1. Have minPrice to a Integer.MAX_VALUE value
            2. Max profit by default = 0
            3. if you find smaller price reSet minPrice
            4. If you find larger profit reset maxProfit
            return profit
*/



public class maxProfit {
    public int getMaxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else{
                int currentProfit = prices[i]-minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        return maxProfit;
    }
}
