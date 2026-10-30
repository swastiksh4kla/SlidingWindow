//BRUTE FORCE  (TLE on large datasets)
//Time Complexity: O(n*k)  &  Space Complexity: O(1)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] retMax = new int[nums.length-k+1];
        int idx = 0;
        for(int i=0; i<nums.length-k+1; i++){
            int max = nums[i];  //Reset max for every new window
            for(int j=i; j<i+k; j++){
                max = Math.max(max, nums[j]);
            }
            retMax[idx] = max;  //add each window's maximum to array
            idx++;
        }
        return retMax;
    }
}
