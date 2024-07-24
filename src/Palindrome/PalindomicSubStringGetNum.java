package Palindrome;
/*
Given a string s, return the number of palindromic substrings in it. A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
*/


/*
        TLDR:
            1. Get Odd Palindrome:
                    Take each string and expand
            2. Get Even Palindrome
                    Take string in even place by doing right+1;
            count = even + odd
*/

public class PalindomicSubStringGetNum {


    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        // For each string we need to expand as if its mid point
        for(int i=0; i<arr.length; i++){
            // Odd length palindrome (both point to same string to start with)
            int left=i, right=i;
            // expand both side with boundary
            while((left>=0)&&(right<arr.length)){
                if(isPalindrome(arr, left, right)){
                    count ++;
                }
                left--;
                right++;
            }

            // This is for Even length --> doing right = i+1;
            left=i;
            right=i+1;
            while((left>=0)&&(right<arr.length)){
                if(isPalindrome(arr, left, right)){
                    count ++;
                }
                left--;
                right++;
            }
        }
        return count;
    }


    // util function
    public boolean isPalindrome(char[] arr, int start, int end){
        if(start>end){
            return false;
        }
        while(start<=end){
            if(arr[start]!=arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
