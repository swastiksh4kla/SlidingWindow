//BRUTE FORCE APPROACH  (TLE on larger dataset)
//Time Complexity: O(n^2)  &  Space Complexity: O(1)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        for(int l=0; l<nums.length; l++){
            int countZero = 0;
            for(int r=l; r<nums.length; r++){
                if(nums[r]==0)  countZero++;
                if(countZero>k) break;
                maxLen = Math.max(maxLen, r-l+1);
            }
        }
        return maxLen;
    }
}


//OPTIMIZED APPROACH
//Time Complexity: O(n)    &    Space Complexity: O(1)
/*class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int countZero = 0;
        int maxLen = 0;
        for(int r=0; r<nums.length; r++){
            if(nums[r]==0)  countZero++;
            while(countZero>k){
                if(nums[l]==0)  countZero--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
}*/
