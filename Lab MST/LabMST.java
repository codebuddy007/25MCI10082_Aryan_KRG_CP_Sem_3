class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];

        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder ans = new StringBuilder();

        for(char ch : s.toCharArray()){
            freq[ch-'a']--;
            if(seen[ch-'a']) continue;
            while(ans.length()>0 && 
            ans.charAt(ans.length()-1) > ch && 
            freq[ans.charAt(ans.length()-1)-'a'] > 0){
                seen[ans.charAt(ans.length()-1)-'a'] = false;
                ans.deleteCharAt(ans.length()-1);
            }
            seen[ch-'a']= true;
            ans.append(ch);
        }
        return ans.toString();
    }
}
