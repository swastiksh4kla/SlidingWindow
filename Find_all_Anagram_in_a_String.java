//BRUTE FORCE (TLE due to two HashMaps and creating substrings of size 'p')
//Time Complexity: O(n*m)  &  Space Complexity: O(m)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> l = new ArrayList<>();
        if(p==null || s==null || s.length()<p.length()) return l;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }
        int left = 0;
        for(int i=p.length(); i<=s.length(); i++){
            if(isAnagram(map, s.substring(left,left+p.length()))){
                l.add(left);
            }
            if(i==s.length())   break;
            left++;
        }
        return l;
    }
    private boolean isAnagram(HashMap<Character, Integer> map, String currWindow){
        HashMap<Character, Integer> tempMap = new HashMap<>();
        for(int i=0; i<currWindow.length(); i++){
            tempMap.put(currWindow.charAt(i), tempMap.getOrDefault(currWindow.charAt(i),0)+1);
        }
        return tempMap.equals(map);
    }
}


//OPTIMIZED SOLUTION (using array)
//Time Complexity: O(n*k)    &    Space Complexity: O(1)
/*
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //OPTIMIZED
        ArrayList<Integer> l = new ArrayList<>();
        if(s==null || p==null || s.length()<p.length()) return l;
        int[] arr_s = new int[26];
        int[] arr_p = new int[26];
        for(int i=0; i<p.length(); i++){
            arr_p[p.charAt(i)-'a']++;
            arr_s[s.charAt(i)-'a']++;
        }
        int left = 0;
        for(int i=p.length(); i<=s.length(); i++){
            if(isAnagram(arr_s, arr_p)){
                l.add(left);
            }
            if(i==s.length())   break;
            arr_s[s.charAt(left)-'a']--;
            arr_s[s.charAt(i)-'a']++;
            left++;
        }
        return l;
    }
    private boolean isAnagram(int[] arr_s, int[] arr_p){
        for(int i=0; i<26; i++){
            if(arr_p[i]!=arr_s[i])  return false;
        }
        return true;
    }
}
*/
