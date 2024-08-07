package M;
/*
Given two sparse vectors, compute their dot product.
Implement class SparseVector:
Follow up: What if only one of the vectors is sparse?

Example 1:
Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8

*/


/*
    SOLUTION:
        TLDR: Since is VECTOR is sparse -- So store only index which has value
            1. Store HashMap<index, value>
            2. use map to calculate sum
*/

import java.util.ArrayList;
import java.util.HashMap;

public class SparseVector {

    HashMap<Integer, Integer> map;
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                map.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        for(HashMap.Entry<Integer, Integer> entry: map.entrySet()){
            int index = entry.getKey();
            if(vec.map.containsKey(index)){
                sum = sum + (vec.map.get(index)*entry.getValue());
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[] nums1 = new int[] {1,0,0,2,3};
        int[] nums2 = new int[] {0,3,0,4,0};
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }

//    ArrayList<int[]> arrayList = new ArrayList<>();
//    SparseVector(int[] nums) {
//        for(int i=0;i<nums.length;i++){
//            if(nums[i] != 0){
//                this.arrayList.add(new int[]{i,nums[i]});
//            }
//        }
//    }
//
//    // Return the dotProduct of two sparse vectors
//    public int dotProduct(SparseVector vector2) {
//        int i = 0;
//        int j = 0;
//        ArrayList<Integer> productList = new ArrayList<>();
//        while ((i<this.arrayList.size())&&(j<vector2.arrayList.size())){
//            if(this.arrayList.get(i)[0] == vector2.arrayList.get(j)[0]){
//                int sum  = this.arrayList.get(i)[1] * vector2.arrayList.get(j)[1];
//                productList.add(sum);
//                i++;
//                j++;
//            }else if(this.arrayList.get(i)[0] < vector2.arrayList.get(j)[0]){
//                i++;
//            }else{
//                j++;
//            }
//        }
//        int result = 0;
//        while(productList.size()>0){
//            result += productList.get(0);
//            productList.remove(0);
//        }
//        return result;
//    }
}
