package Stock;

/*
    PROBLEM: Can buy and sell same day -- max profit
*/

/*
    SOLUTION:
        TLDR: we only add to profit if we see one.
        We want to predict next day --- so we have pointer for next day

        1. have 2 pointers
        2. today and tomorrow
        3. increment them till tomorrow is end of array
        4. every step see if you are making that profit
        5. if so add and thats the profit

*/


public class MultiTransactionProfit {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        int i=0;
        int j=1;
        int profit = 0;
        while(j<prices.length){
            if(prices[j]-prices[i]>0){
                profit = profit + (prices[j]-prices[i]);
            }
            i++;
            j++;
        }
        return profit;
    }
}
