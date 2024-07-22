package TrickQuestons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/*
Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Implement the Solution class:
Solution(int[] nums) Initializes the object with the array nums.
int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.
*/


/*
        TLDR:
            Note: All index has equal probability:
                  1. Create hash Map with <value, list of index>
                  2. Pick randomly from list for each target value
*/

public class RandomPickIndex {
    HashMap<Integer, ArrayList<Integer>> map;
    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            ArrayList<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        ArrayList<Integer> targetList = map.get(target);
        Random random = new Random();
        int randomIndex = random.nextInt(targetList.size());
        return targetList.get(randomIndex);
    }
}
