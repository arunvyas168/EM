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
        I am using DFS here. I have a start level of 1
        I am passing it to helper along with result array
    */
    public int depthSum(List<NestedInteger> nestedList) {
        ArrayList<Integer> list = new ArrayList<>();
        int depth = 1;
        depthSumUtil(nestedList, depth, list);
        int sum = 0;
        for(int num: list){
            sum = sum+num;
        }
        return sum;
    }


    /*
    IN the helper:
        I am looping over the list
        If I see integer I construct the product and add to list
        If I see list I pass to helper with level+1
    */
    public void depthSumUtil(List<NestedInteger> nestedList, int depth, ArrayList<Integer> list){
        for(NestedInteger object: nestedList){
            if(object.isInteger()){
                int value = object.getInteger() * depth;
                list.add(value);
            }else{
                depthSumUtil(object.getList(), depth+1, list);
            }
        }
    }
}
