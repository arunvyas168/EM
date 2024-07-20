package TrickQuestons;

/*
Decode String

Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.


Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/

/*
    Solution:

    TLDR:
        1. Use a stack
        2. We need to compute per bracket close and push it back to stack
        3. use for loop to push char to stack
        3. Push and push til you see ']'
        4. If you see a ']' compute -------> call seperate function function
                buildProductStack:
                    1. create new sb
                    2. while stack not empty
                    3. pop the top
                    4. if top not '[' insert in 0th place sb
                    5. This Sb will be the string we need to multiply
                    6. get the number ---> using the num*10+digit
                    7. keep appneding sb to new SB
                    8. push character to stack ----->> very imp

        Note: Pop the stack and insert in 0th place to REVERSE and return string

*/

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String encoded){
        // use stack
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();


        for(int i=0;i<encoded.length();i++){
            // keep pushing till you see ']'
            if(encoded.charAt(i)!=']'){
                stack.push(encoded.charAt(i));
            }else {
                // when you see ']'
                buildProductStack(stack);
            }
        }

        // now stack contains the string---> since we are poping we need to do insert at 0
        while (!stack.isEmpty()){
            result.insert(0,stack.pop());
        }

        // return
        return result.toString();
    }


    public static void buildProductStack(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();
        // this is to find the number
        int number = 0;

        // we pop till we find '[' to know what's the string
        while(!stack.isEmpty()){
            Character top = stack.pop();
            if(top!='['){
                // since pop use insert 0
                sb.insert(0, top);
            }else {
                break;
            }
        }
        // need place value if we are doing in reverse
        int placeValue = 1;
        while ((!stack.isEmpty())&&(Character.isDigit(stack.peek()))){
            // place value will decide if its units, tens, hundreds
            number += Character.getNumericValue(stack.pop()) * placeValue;
            placeValue = placeValue*10;
        }

        // post we have string and number, multiple string with number and push back in stack
        StringBuilder newSB = new StringBuilder();
        while(number>0){
            newSB.append(sb);
            number--;
        }

        // need for loop to push one by one
        for(int i= 0; i<newSB.length(); i++){
            stack.push(newSB.charAt(i));
        }
    }


    public static void main(String[] args){
        String input = "3[a]2[bc]";
        System.out.println(decodeString(input));
        input = "3[a2[c]]";
        System.out.println(decodeString(input));
        input = "2[abc]3[cd]ef";
        System.out.println(decodeString(input));
        input = "100[leetcode]";
        System.out.println(decodeString(input));
    }

}
