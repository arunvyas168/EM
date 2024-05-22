package M;

import java.util.HashMap;

/*
    QUESTION:
    You are given two strings order and s. All the characters of order are unique and were sorted in some custom order
    Permute the characters of s so that they match the order that order was sorted.

    Input: order = "cba", s = "abcd"
    Output: "cbad"

    Input: order = "bcafg", s = "abcd"
    Output: "bcad"
*/

/*
    SOLUTION:
        TLDR:
            1. Take the string and put in hash Map {Character,Count}
            2. StringBuilder
            3. Iterate Order string
                If Char there in Map -- add to SB * count  -----> Remove from Map
            4. NOTE: -- Make sure to REMOVE from MAP
                    5. Iterate rest of map and add to SB*count again
        Return String
*/


public class customOrderSort {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : order.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0;i<map.get(c);i++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(HashMap.Entry<Character, Integer> entry: map.entrySet()){
            for(int i=0;i<entry.getValue();i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
