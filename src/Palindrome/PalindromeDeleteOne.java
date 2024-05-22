package Palindrome;
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.
*/

/*
    SOLUTION:
       1. Use two pointer start and end;
       2. As they converge check for match
       3. If they don't match just see if substring match without
       start+1 or end-1

   Note: can be done recursively -- see DeleteK
*/


public class PalindromeDeleteOne {
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
