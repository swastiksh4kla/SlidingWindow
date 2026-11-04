//INITIAL APPROACH
//Time Complexity: O(n*m)  &  Space Complexity: O(1)
class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length()) return "";
        int[] arr_t = new int[128];
        for(int i=0; i<t.length(); i++){
            arr_t[t.charAt(i)]++;
        }
        int minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        int[] arr_s = new int[128];
        int left = 0;
        for(int i=0; i<s.length(); i++){
            arr_s[s.charAt(i)]++;
            while(isValid(arr_t, arr_s)){
                int currLen = i-left+1;
                if(currLen<minLen){
                    minLen = currLen;
                    startIdx = left;
                }
                arr_s[s.charAt(left)]--;
                left++;
            }
        }
        return startIdx == -1?"":s.substring(startIdx, startIdx+minLen);
    }
    private boolean isValid(int[] arr_t, int[] arr_s){
        for(int i=0; i<128; i++){
            if(arr_s[i]<arr_t[i])   return false;
        }
        return true;
    }
}
