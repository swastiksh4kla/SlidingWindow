//BRUTE FORCE SOLUTION
//Time Complexity: O(n^2)  &  Space Complexity: O(1)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int prod = 1;
            for(int j=i; j<nums.length; j++){
                prod *= nums[j];
                if(prod>=k)  break;
                count++;
            }
        }
        return count;        
    }
}

//OPTIMIZED SOLUTION
//Time Complexity: O(n)  &  Space Complexity: O(1)
/*class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)    return 0;
        int i=0;
        int count=0;
        int prod = 1;
        for(int j=0; j<nums.length; j++){
            prod *= nums[j];
            while(prod>=k){
                prod /= nums[i];
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }
}*/
