package M;

/*
A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.
For example:
"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)
*/

/*
    SOLUTION:
        TLDR: -- have abbr pointer and string ptr --> get number and skip and make sure char match
           Note:--- in the end make sure both index is ending
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
                    // corner case if something like 01
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
