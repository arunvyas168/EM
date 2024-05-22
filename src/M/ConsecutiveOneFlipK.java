package M;

/*
Question: You can flip max of K 0 to 1. what's the maximum consecutive one return size
*/


/*
    SOLUTION:
        1. TWO POINTER (start and end)
        2. When you see 0 flip it and subtract k
        3. If k=0 then we shift window --> meaning shift left pointer
            When we shift left if it was 0 then increment k else just shift;

*/

public class ConsecutiveOneFlipK {
    public int longestOnes(int[] nums, int k) {
        if(nums.length==0){
            return -1;
        }



        // move left when k is less than 1 -->  but if its currently on 0 we have to increment
        int left = 0;
        //right increments only when there is 1 or k left
        int right = 0;


        // Keep track of size with max size
        int size = 0;

        // right keeps moving
        // Left moves when k == 0   ---> sliding window
        // When it moves we see if nums[left] was 0 or 1 -- and we increment K if needed


        while(right<nums.length){
            if(nums[right]==1){         // if 1 increase
                right++;
            }else{
                if(k>0){                // check k value
                    k--;                // if we can flip then --
                    right++;
                }else{
                    if (nums[left]==0){     // if k is 0 before incrementing left see if the value is 0 or 1 ----> based on which k will be incremented
                        k++;
                    }
                    left++;
                }
            }
            size = Math.max(size, right-left);  // do right-left
        }
        return size;
    }
}
