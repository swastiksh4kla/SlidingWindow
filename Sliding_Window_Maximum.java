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



//OPTIMIZED (using ArrayDeque, which helps to insert and remove from both ends of a Queue)
//Time Complexity: O(n)    &    Space Complexity: o(k)

/*class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int idx = 0;
        int[] arr = new int[n-k+1];
        for(int i=0; i<n; i++){
            //removing all the indices which are exceeding window size
            while(!q.isEmpty() && q.peekFirst()<i-k+1) q.pollFirst();
            //removing all the indices whose elements are smaller than the element at ith idx
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])   q.pollLast();
            q.offerLast(i);    //inserting new element to q
            if(i>=k-1)   arr[idx++] = nums[q.peekFirst()];
        }
        return arr;
    }
}*/
