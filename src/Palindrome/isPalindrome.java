package Palindrome;

public class isPalindrome {
    public static boolean validPalindrome(String s) {
        if(s==null){
            return false;
        }
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        String input = "abca";
        System.out.println(validPalindrome(input));
    }
}
