package Comparator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    /*
    Leetcode 767 Reorganize String
    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
    Return any possible rearrangement of s or return "" if not possible.

    Example 1:
    Input: s = "aab"
    Output: "aba"
    Example 2:

    Input: s = "aaab"
    Output: ""

    Constraints:
    1 <= s.length <= 500
    s consists of lowercase English letters.
     */

    public  static String getReorganizedString(PriorityQueue<Map.Entry<Character, Integer>> pq, String originalString){
        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> previous = null;
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            result.append(entry.getKey());
            entry.setValue(entry.getValue() -1);
            if(previous!=null && previous.getValue()>0 && previous.getKey()!=entry.getKey()){
                pq.add(previous);
            }
            previous = entry;
        }
        return originalString.length() == result.length() ? result.toString() : "";
    }

    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            int val = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i), val+1);
        }
        /*
            Original code:
            for(Map.Entry<Character, Integer> e : map.entrySet()){
                pq.add(e);
            }
            Better coding standard
         */
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(map.entrySet());

        return getReorganizedString(pq, s);
    }

    public static void main(String [] args){
        String output  =  reorganizeString("aab");
        System.out.println(output);
    }
}
