package Comparator;

import java.util.HashMap;
import java.util.PriorityQueue;

/*
    QUESTION: Given a string s, sort it in decreasing order based on the frequency of the characters. Return the sorted string.
    Example 1:
        Input: s = "tree"
        Output: "eert"              Explanation: 'e' appears twice while 'r' and 't' both appear once.
                                    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/


/*
    SOLUTION:
        1. Use HashMap to store {char:count}
        2. Use Priority queue to sort by VALUE  ---- Reverse ORDER
        3. Use StringBuilder to construct the result
*/

public class SortCharFerequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<HashMap.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
        }
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            HashMap.Entry<Character, Integer> entry  = pq.poll();
            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
