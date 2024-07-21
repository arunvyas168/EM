package M;
/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:
Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:
Input: num1 = "456", num2 = "77"
Output: "533"
*/



/*
        TLDR:
            1. Elementary Math
            2. Just keep track of carry with %10
            3. dont forget to add carry

*/

public class AddStringElementaryMath {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while((i>=0)&&(j>=0)){
            int sum = (int)(num1.charAt(i)-'0') + (int)(num2.charAt(j)-'0')+carry;
            if(sum>9){
                carry =1;
            }else{
                carry = 0;
            }
            result.insert(0,sum%10);
            i--;
            j--;
        }

        while(i>=0){
            int sum = (int)(num1.charAt(i)-'0') + carry;
            if(sum>9){
                carry =1;
            }else{
                carry = 0;
            }
            result.insert(0,sum%10);
            i--;
        }
        while(j>=0){
            int sum = (int)(num2.charAt(j)-'0') + carry;
            if(sum>9){
                carry =1;
            }else{
                carry = 0;
            }
            result.insert(0,sum%10);
            j--;
        }
        if(carry==1){
            result.insert(0,1);
        }
        return result.toString();
    }
}
