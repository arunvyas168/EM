package M;

/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.


Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

*/

public class MinimumRemoveParantheses {
    public static String removeMinimumParanthesesMakeValid(String s){
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            } else if (s.charAt(i) == ')') {
                if(open==0){
                    continue;
                }
                open--;
            }
            sb.append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for(int i=sb.length()-1; i>=0;i--){
            if((sb.charAt(i) == '(') && (open>0)){
                open--;
                continue;
            }
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();

    }

    public static void main (String [] args){
        String input = "())()(((";
        System.out.println(removeMinimumParanthesesMakeValid(input));
    }
}
