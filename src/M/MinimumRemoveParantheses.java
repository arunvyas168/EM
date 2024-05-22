package M;
/*
Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"                  Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:
Input: s = "))(("
Output: ""                          Explanation: An empty string is also valid.
*/

/*
    SOLUTION:
        TLDR: We use string builder for constructing result
              We use openCount and when we see a ) without openCount --> Skip
        NOTE:  finally-- traverse reverse --> till openCount>0 ---> skip (
        Also NOTE: 2nd traversal since its traversing reversing use sb.insert(0,str)
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
            result.insert(0,sb.charAt(i));
        }
        return result.toString();

    }

    public static void main (String [] args){
        String input = "())()(((";
        System.out.println(removeMinimumParanthesesMakeValid(input));
    }
}
