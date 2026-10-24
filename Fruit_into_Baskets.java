//Time Complexity: O(n) 
//Space Complexity: O(1)
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int start = 0;
        int maxFruits = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int end=0; end<n; end++){
            map.put(fruits[end],map.getOrDefault(fruits[end],0)+1);
            while(map.size()>2){
                map.put(fruits[start],map.get(fruits[start])-1);
                if(map.get(fruits[start])==0)   map.remove(fruits[start]);
                start++;
            }
            maxFruits = Math.max(maxFruits,(end-start+1));
        }
        return maxFruits;
    }
}
