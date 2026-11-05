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
