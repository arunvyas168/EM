package M;

/*
Question: You can flip max of ONE 0 to 1. what's the maximum consecutive one return size
*/


/*
    SOLUTION:
        1. TWO POINTER (start and end)
        2. When you see 0 flip it and subtract the (counter=1)
        3. If counter=0 then we shift window --> meaning shift left pointer
            When we shift left if it was 0 then increment counter++ else just shift;

*/

public class consecutiveOneflipOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0){
            return -1;
        }

        // window move only if numZero is less than 1
        int numZero = 1;

        // move left when numZero is less than 1 -->  but if its currently on 0 we have to increment
        int left = 0;

        //right increments only when there is 1 or numZero left
        int right = 0;
        int size = 0;

        while(right<nums.length){
            if(nums[right]==1){     //right increments only when there is 1 or numZero left
                right++;
            }else{
                if(numZero>0){             //right increments only when there is 1 or numZero left
                    right++;
                    numZero--;
                }else{
                    if(nums[left]==0){      // move left when numZero is less than 1 -->  but if its currently on 0 we have to increment
                        numZero++;
                    }
                    left++;
                }
            }
            size = Math.max(size, right-left);
        }
        return size;
    }
}
