package M;

/*
A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

For example, a string such as "substitution" could be abbreviated as (but not limited to):

"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)
The following are not valid abbreviations:

"s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
"s010n" (has leading zeros)
"s0ubstitution" (replaces an empty substring)
Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

A substring is a contiguous non-empty sequence of characters within a string.



Example 1:

Input: word = "internationalization", abbr = "i12iz4n"
Output: true
Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
Example 2:

Input: word = "apple", abbr = "a2e"
Output: false
Explanation: The word "apple" cannot be abbreviated as "a2e".


Constraints:

1 <= word.length <= 20
word consists of only lowercase English letters.
1 <= abbr.length <= 10
abbr consists of lowercase English letters and digits.
All the integers in abbr will fit in a 32-bit integer.

*/

public class WordAbbreviation {

    public static boolean isWordAbbreviation(String word, String abbr){
        int wordIndex = 0;
        int abbrIndex = 0;
        while((wordIndex<word.length())&&(abbrIndex<abbr.length())){
            if((word.charAt(wordIndex)) == abbr.charAt(abbrIndex)){
                wordIndex++;
                abbrIndex++;
            }else{
                if(!Character.isDigit(abbr.charAt(abbrIndex))){
                    return false;
                }
                int num = 0;
                while((abbrIndex<abbr.length())&&(Character.isDigit(abbr.charAt(abbrIndex)))){
                    num = (num*10) + ((int)abbr.charAt(abbrIndex)-'0');
                    if(num==0){
                        return false;
                    }
                    abbrIndex++;
                }
                wordIndex = wordIndex+num;
                if(wordIndex>word.length()){
                    return false;
                }
            }
        }
        return (wordIndex == word.length()) && (abbrIndex == abbr.length());
    }

    public static void main (String [] args){
        String word = "internationalization";
        String abbr = "i5a11o1";
        System.out.println(isWordAbbreviation(word, abbr));
    }

}
