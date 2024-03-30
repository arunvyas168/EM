package Palindrome;
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/
public class ValidPalindromeTwo {
    public static boolean isSubStringPalindrome(String s, int start, int end){
        if(end-start+1>s.length()){
            return false;
        }
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindromeMaxRemove1(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isSubStringPalindrome(s, start + 1, end) || isSubStringPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        String input = "abca";
        System.out.println(isPalindromeMaxRemove1(input));
    }

}
