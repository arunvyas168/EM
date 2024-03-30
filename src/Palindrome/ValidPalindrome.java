package Palindrome;


/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */

public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            while((start<end)&&(!Character.isLetterOrDigit(s.charAt(start)))){
                start++;
            }
            while((start<end)&&(!Character.isLetterOrDigit(s.charAt(end)))){
                end--;
            }
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args){
        String input = "4A man, a plan, a canal: Panama4$$";
        System.out.println(isPalindrome(input));
    }
}
