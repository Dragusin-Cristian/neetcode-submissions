class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start = 0;

        Map<Character, Integer> indexes = new HashMap<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // verify duplicate and start position
            if (indexes.get(c) != null) {
                // update start
                start = indexes.get(c) + 1;
                // clear the map and add all letters up until current letter
                indexes.clear(); //?
                for (int j = start; j < i; j++) {
                    indexes.put(chars[j], i);
                }
            }

            // add letter index to map
            indexes.put(c, i);

            // verify max
            max = Math.max(max, indexes.size());
        }

        return max;
    }
}
