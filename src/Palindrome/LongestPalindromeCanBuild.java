package Palindrome;

import java.util.HashSet;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
*/



/*
        TLDR:
            1. Use Hashmap
            2. Every time a duplicate is seen ---> increase count by 2 --> remove from map
            3. HashMap will be empty or will have non duplicate string
            4. Count = count+2 for every duplicate
            5. if map empty return count if not Plus 1 for (even palindrome)
*/

public class LongestPalindromeCanBuild {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                count = count+2;
                set.remove(s.charAt(i));
            }else{
                set.add(s.charAt(i));
            }
        }
        if(set.isEmpty()){
            return count;
        }else{
            return count+1;
        }
    }
}
