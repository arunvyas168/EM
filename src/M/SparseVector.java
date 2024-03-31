package M;
/*
Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?



Example 1:

Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
Example 2:

Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
Example 3:

Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6

*/

import java.util.ArrayList;

public class SparseVector {
    ArrayList<int[]> arrayList = new ArrayList<>();
    SparseVector(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                this.arrayList.add(new int[]{i,nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vector2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> productList = new ArrayList<>();
        while ((i<this.arrayList.size())&&(j<vector2.arrayList.size())){
            if(this.arrayList.get(i)[0] == vector2.arrayList.get(j)[0]){
                int sum  = this.arrayList.get(i)[1] * vector2.arrayList.get(j)[1];
                productList.add(sum);
                i++;
                j++;
            }else if(this.arrayList.get(i)[0] < vector2.arrayList.get(j)[0]){
                i++;
            }else{
                j++;
            }
        }
        int result = 0;
        while(productList.size()>0){
            result += productList.get(0);
            productList.remove(0);
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums1 = new int[] {1,0,0,2,3};
        int[] nums2 = new int[] {0,3,0,4,0};
        SparseVector v1 = new SparseVector(nums1);
        SparseVector v2 = new SparseVector(nums2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }

}
