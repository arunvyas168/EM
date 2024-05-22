package M;

import java.util.Stack;

/*
Basic Calculator 2
Given a string s which represents an expression, evaluate this expression and return its value.

Example 1:
Input: s = "3+2*2"
Output: 7


ASK --- any other spl char
    --- division will return int is that ok for now
*/


/*

    SOLUTION:
        1. Use STACK
        2. Goal:
            if + the push positive number
            if - push negative number
            if * pop last number multiply and the push back
            if / pop last number devide and the push back
        2. have currentNumber and currentOperator
        3. start Iterating
        NOTE: --
            each loop will compute number --- (no need of while loop with *10)
            each loop will set new operator and new number in the END

     In the end add all number (the -ve numbers will take care of themselves)

 */


public class BasicCalculator {
    public static int calculate(String s) {
        s = s.replaceAll("\\s","");
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char currentOperator = '+';
        for(int i=0; i<s.length(); i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                currentNumber = (currentNumber *10)+ (currentChar-'0');
            }
            if((!Character.isDigit(currentChar))|| (i == s.length() - 1)){
                if(currentOperator=='-'){
                    stack.push(-currentNumber);
                }
                if(currentOperator=='+'){
                    stack.push(currentNumber);
                }
                if(currentOperator=='*'){
                    currentNumber =  currentNumber * stack.pop();
                    stack.push(currentNumber);
                }

                if(currentOperator=='/'){
                    currentNumber =  stack.pop()/ currentNumber;
                    stack.push(currentNumber);
                }
                currentOperator = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args){
        String expression = "3/2";
        System.out.println(calculate(expression));
    }

}

