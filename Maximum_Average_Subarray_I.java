//Time Compleity: O(n)
//Space Complexity: O(1)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        if(k==nums.length)  return (double)sum/k;
        double maxSum = sum;
        for(int i=k; i<nums.length; i++){
            sum = sum+nums[i]-nums[i-k];
            maxSum = Math.max(sum,maxSum);
        }
        return (double)maxSum/k;
    }
}
