package TrickQuestons;

//Dont know :(
/*
    Solution:

    Constructor:
        1. we take input array
        2. and we compute new array of cumulativeSum (0-n)
        3. we do that by adding in for loop and appending to array.
        4. we also have full sum

    PickItem
        1. we use Math.random() * the tolal_sum -- to get target zone
        2. we iterate the cumulativeSumArray list
        3. if we find index thats less than target zone

*/


public class RandomPickWeight {
    private int[] prefixSumArray;
    private int totalSum;

    public RandomPickWeight(int[] w) {
        this.prefixSumArray = new int[w.length];

        int cumulativeSum = 0;
        for (int i = 0; i < w.length; ++i) {
            cumulativeSum += w[i];
            this.prefixSumArray[i] = cumulativeSum;
        }
        this.totalSum = cumulativeSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        while(i < this.prefixSumArray.length){
            if (target<=this.prefixSumArray[i]){
                break;
            }
            i++;
        }

        return i;
    }
}
