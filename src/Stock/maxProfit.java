package Stock;

/*
    QUESTION:

    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/


/*
    SOLUTION:
        TLDR: If profit take max of profit
              if price goes down than now, just move your buy price

        1. Have a holdPrice
        2. have a futurePrice
        3. If future is small make that your hold price
        4. Otherwise calculate profit and keep track of max profit
*/



public class maxProfit {
    public int maxProfits(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int holdPrice = 0;
        int future = 1;
        int maxProfit = 0;

        while(future<prices.length){
            if(prices[future]<prices[holdPrice]){
                holdPrice = future;
                future++;
            }else{
                maxProfit = Math.max(maxProfit, (prices[future]-prices[holdPrice]));
                future++;
            }
        }
        return maxProfit;
    }
}
