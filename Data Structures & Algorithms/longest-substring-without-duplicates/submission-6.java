class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int max = 0, start = 0;

        Map<Character, Integer> lastSeen = new HashMap<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (lastSeen.get(c) != null && lastSeen.get(c) >= start) {
                // set the start to prevIndex +1
                start = lastSeen.get(c) +1;
                
            }

            // update index or add new char
            lastSeen.put(c, i);

            max = Math.max(max, i - start +1);

        }

        return max;
    }
}
