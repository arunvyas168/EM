package M;

import java.util.ArrayList;
import java.util.List;


/*
    SOLUTION:
        TlDR: we recursively pass the list till we get an integer. we use level to track the product.
        1. use util for recursion--->
        2. pass level starting with 1
        3. In the util we go element by element -->

*/


public class NestListSum {
    public interface NestedInteger {
        public List<NestedInteger> getList();
        public boolean isInteger();
        public Integer getInteger();
    }

/*
IN the helper:

I am looping over the list
If I see integer I construct the product and add to list
If I see list I pass to helper with level+1
*/
    public void depthSumUtil(List<NestedInteger> nestedList, int level, ArrayList<Integer> list){
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                int product = ni.getInteger()*level;
                list.add(product);
            }else{
                depthSumUtil(ni.getList(), level+1, list);
            }
        }
    }



/*
I am using DFS here. I have a start level of 1
I am passing it to helper along with result array
*/
    public int depthSum(List<NestedInteger> nestedList) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int level = 1;
        depthSumUtil(nestedList, level, list);
        for(Integer i: list){
            sum += i;
        }
        return sum;
    }
}
