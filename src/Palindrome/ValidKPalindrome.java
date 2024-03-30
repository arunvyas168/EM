package Palindrome;

public class ValidKPalindrome {
    public static boolean isValidKPalindrome(String s, int k) {
        int start = 0;
        int end = s.length()-1;
        return isValidKPalindromeUtil(s, start, end, k);
    }
    public static boolean isValidKPalindromeUtil(String s, int start, int end, int k){
        if((end<start)||(end-start+1>s.length())||(k<0)){
            return false;
        }
        while(end>start){
            if(s.charAt(start)!=s.charAt(end)){
                k--;
                return isValidKPalindromeUtil(s, start+1, end, k) || isValidKPalindromeUtil(s, start, end-1, k);
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        //Test-1
        String input = "abcdeca";
        int k = 2;
        System.out.println(isValidKPalindrome(input, k));
        //Test-2
        input = "abbababa";
        k = 1;
        System.out.println(isValidKPalindrome(input, k));
//        //Test-3 -- does not work
//        input = "fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd";
//        k = 216;
//        System.out.println(isValidKPalindrome(input, k));

    }
}
