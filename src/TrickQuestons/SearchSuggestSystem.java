package TrickQuestons;

/*
You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.



Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.


Constraints:

1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.
*/

/* Solution Logic

        Now first we have to sort the product list

        we can have left = 0
        and right in the end (len-1)

        If Sorted we know Start and End for a given sub string of search word
        use for loop ---> searchWord.substring(0,i)

        return 3;



*/


import java.util.ArrayList;
import java.util.Arrays;

public class SearchSuggestSystem {

    public static ArrayList<ArrayList<String>> suggestedProduct(String[] productList, String searchWord){
        Arrays.sort(productList); //O(NLogN)
        int left = 0;
        int right = productList.length-1;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        /* Note time complexity of substring changed from O(1) to O(n) post java6 https://stackoverflow.com/questions/31933227/how-to-create-our-own-o1-substring-function-in-java-as-it-was-in-jdk-6
                So use
            String newstr = new String(oldStr.substring(5,9));
                rather than the more sensible-looking:
            String newstr = oldStr.substring(5,9);
        */

        for(int i=1; i<=searchWord.length(); i++){
            String key = searchWord.substring(0,i);
            while((left<=right)&&(key.length()<=productList[left].length())){
                if(productList[left].startsWith(key)){
                    break;
                }
                left++;
            }
            while((left<=right)&&(key.length()<=productList[right].length())){
                if(productList[right].startsWith(key)){
                    break;
                }
                right--;
            }
            int start = left;
            ArrayList<String> list = new ArrayList<>();
            while((start<=right)&&list.size()<3){
                list.add(productList[start]);
                start++;
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args){
        String[] productList = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        ArrayList<ArrayList<String>> result = suggestedProduct(productList, searchWord);
        for(ArrayList<String> list : result){
            for (String element : list) {
                System.out.print(element+" ");
            }
            System.out.println(" ");
        }
    }

}
