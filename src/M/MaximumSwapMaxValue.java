package M;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.
Return the maximum valued number you can get.

Example 1:
Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.
*/



/*
        TLDR:
            1. For a given index we need a way to know if there is a bigger number in front
            2. So start reverse and start storing that for each index
*/
public class MaximumSwapMaxValue {
    // This Info needs to be saved for each index
    static class SwapElement{
        int maxSeen;
        int maxAtIdx;
        public SwapElement(int maxSeen, int maxAtIdx){
            this.maxSeen = maxSeen;
            this.maxAtIdx = maxAtIdx;
        }
    }

    // Start of the function
    public static int maximumSwap(int num) {
        // convert number to list of digits
        ArrayList<Integer> input = new ArrayList<>();
        while(num>0){
            int digit = num%10;
            num = num/10;
            input.add(0,digit);
        }

        // For a given index Store what's max value and index in future
        HashMap<Integer, SwapElement> map = new HashMap<>();
        int maxSeen = Integer.MIN_VALUE;
        int maxSeenAt = -1;
        // go reverse
        for(int i=input.size()-1; i>=0; i--){
            map.put(i,new SwapElement(maxSeen, maxSeenAt));
            if(input.get(i)>maxSeen){
                maxSeen = input.get(i);
                maxSeenAt = i;
            }
        }

        // Now that you have max value in the future, Swap
        for(int j=0; j<input.size();j++){
            SwapElement element = map.get(j);
            if(input.get(j)<element.maxSeen){
                Collections.swap(input, j, element.maxAtIdx);
                break;
            }
        }

        //now construct integer back

        int result = 0;
        for(int n:input){
            result = (result*10)+n;
        }
        return result;
    }


    public static void main(String[] args){
        int input = 20;
        System.out.println(maximumSwap(input));
    }
}

/*
    Better clean way:

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] lastSeen = new int[10];

        // Record the last seen index of each digit
        for (int i = 0; i < digits.length; i++) {
            lastSeen[digits[i] - '0'] = i;
        }

        // Find the first index to swap
        for (int i = 0; i < digits.length; i++) {
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (lastSeen[d] > i) {
                    // Swap the digits
                    char temp = digits[i];
                    digits[i] = digits[lastSeen[d]];
                    digits[lastSeen[d]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
*/