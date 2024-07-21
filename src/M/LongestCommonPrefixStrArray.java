package M;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
*/


/*
        TLDR:
            Take string one and do a Virtical scan
            Take 1st char and scan across all string in array
            O(nk) --> n-> number of elements, k-> with of string
*/

public class LongestCommonPrefixStrArray {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if(strs.length==0){
            return result;
        }
        String compareString = strs[0];
        for(int i=0; i<compareString.length();i++){
            for(String str: strs){
                if((str.length()==i)||(compareString.charAt(i)!=str.charAt(i))){
                    return result;
                }
            }
            result = result+compareString.charAt(i);
        }
        return result;
    }

    public static void main(String[] args){
        String[] input;
        input = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input));
        input = new String[] {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(input));
        input = new String[] {""};
        System.out.println(longestCommonPrefix(input));
        input = new String[] {"","","flight"};
        System.out.println(longestCommonPrefix(input));
        input = new String[] {};
        System.out.println(longestCommonPrefix(input));
        input = new String[] {"flow","flow","flow"};
        System.out.println(longestCommonPrefix(input));
//        input =null;
//        System.out.println(longestCommonPrefix(input));
    }
}
