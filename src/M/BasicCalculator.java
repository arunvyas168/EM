package M;

import java.util.ArrayList;

/*
Basic Calculator 2
Given a string s which represents an expression, evaluate this expression and return its value.

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5

*/
public class BasicCalculator {
    public static int calculate(String s) {
        ArrayList<String> sublist = new ArrayList<>();
        ArrayList<String> addlist = new ArrayList<>();
        ArrayList<String> prodlist = new ArrayList<>();
        ArrayList<String> divlist = new ArrayList<>();
        //split by - operator
        String[] subArray = s.split("-");
        for(String str : subArray){
            sublist.add(str);
        }
        for(String str:  sublist){

        }

}
