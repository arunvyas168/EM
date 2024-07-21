package Stock;

/*
    PROBLEM: Can buy and sell same day -- max profit
*/

/*
    SOLUTION:
        TLDR:
        Trick:--  we only care about price increase and we add profit.
                  we buy in dip and sell when high
                  We only care about next element

        1. have 2 pointers
        2. today and tomorrow
        3. while (tomorrow < array.length)
        4. see if (tomorrow-today) is profitable
        5. Add if profit

*/


public class MultiTransactionProfit {
    public int maxProfit(int[] prices) {
        // imp "<=" to have 2 pointer
        if(prices.length<=1){
            return 0;
        }
        int today=0;
        int tomorrow=1;
        int profit = 0;  // default profit

        while(tomorrow<prices.length){
            if(prices[tomorrow]-prices[today]>0){
                profit = profit + (prices[tomorrow]-prices[today]);
            }
            today++;
            tomorrow++;
        }
        return profit;
    }
}
