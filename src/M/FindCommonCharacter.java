package M;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]
*/


/*
        TLDR:
            1. We create one common hashmap
            2. We create one sub hashmap
            3. We minimize and reset the common hash map
*/
public class FindCommonCharacter {
    public List<String> commonChars(String[] words) {
        if(words.length==0){
            return new ArrayList<>();
        }
        HashMap<Character, Integer> commonMap = new HashMap<>();

        // good to use loadMapwithCount function as we ll be doing more of this
        loadMapwithCount(words[0], commonMap);

        for(String word : words){
            HashMap<Character, Integer> currentMap = new HashMap<>();
            loadMapwithCount(word, currentMap);

            // good to use a minimize function
            commonMap = getMinCountMap(commonMap, currentMap);
        }
        List<String> result = new ArrayList<>();
        for(HashMap.Entry<Character, Integer> e: commonMap.entrySet()){
            int count = e.getValue();
            while(count>0){
                result.add(e.getKey().toString());
                count--;
            }
        }
        return result;
    }

    public HashMap<Character, Integer> getMinCountMap(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
        HashMap<Character, Integer> resultMap = new HashMap<>();
        for (Character key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int minCount = Math.min(map1.get(key), map2.get(key));
                resultMap.put(key, minCount);
            }
        }
        return resultMap;
    }

    public void loadMapwithCount(String word, HashMap<Character, Integer> map){
        for(Character c: word.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
    }
}
