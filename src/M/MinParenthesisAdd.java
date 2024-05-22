package M;
/*
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3
*/

/*
    SOLUTION:
        TLDR: have openCount and closeCount
              1. increase openCount when you see (
              2. when you see ) if open=0 then closeCount++ else openCount--
              3. Answer will be open + close
*/

public class MinParenthesisAdd {

    public static int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        char[] array = s.toCharArray();
        for(char c : array){
            if(c=='('){
                open++;
            }else if(c==')'){
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }

        return open+close;
    }

    public static void main(String[] args){
        String input = "())";
        System.out.println(minAddToMakeValid(input));
        input = "(((";
        System.out.println(minAddToMakeValid(input));
    }
}
