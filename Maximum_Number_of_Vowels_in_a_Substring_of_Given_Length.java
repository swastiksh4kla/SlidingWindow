//OPTIMIZED APPROACH
//Time Complexity: O(n)  &  Space Complexity: O(1)
class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i)))    count++;
        }
        int maxCount = count;
        for(int i=k; i<s.length(); i++){
            if(isVowel(s.charAt(i-k)))  count--;
            if(isVowel(s.charAt(i)))    count++;
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
    private boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}



//SELF (ALTERNATE) APPROACH - Two Pointer
//Time Complexity: O(n)  &  Space Complexity: O(1)
/*class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(j<k){
            if(isVowel(s.charAt(j)))    count++;
            j++;
        }
        int maxCount = count;
        while(j<s.length()){
            i++;
            if(isVowel(s.charAt(i-1)))  count--;
            if(isVowel(s.charAt(j)))    count++;
            maxCount = Math.max(count, maxCount);
            j++;
        }
        return maxCount;
    }
    private boolean isVowel(char c){
      if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
      return false;
    }
}*/
