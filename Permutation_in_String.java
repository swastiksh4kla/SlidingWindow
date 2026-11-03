//BRUTE FORCE
//Time Complexity: O(n*mlogm)  &  Space Complexity: O(n+m)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()  || s2==null || s2.length()==0) return false;
        char[] c1 = s1.toCharArray();//Convert s1 to char array
        Arrays.sort(c1);
        String sort1 = new String(c1);//s1 sorted

        int l = 0;
        int r = s1.length();
        while(r<=s2.length()){
            String secStr = s2.substring(l,r);
            char[] c2 = secStr.toCharArray();//Convert s2 to char array
            Arrays.sort(c2);
            String sort2 = new String(c2);//s2 sorted
            if(sort1.equals(sort2)) return true;
            l++;
            r++;
        }
        return false;
    }
}
