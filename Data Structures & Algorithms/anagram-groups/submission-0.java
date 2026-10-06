class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // a hashmap with keys as ordered chars word, and 
        // as values the actual words
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String word : strs) {
            String ordered = orderChars(word);
            anagramsMap
            .computeIfAbsent(ordered, k -> new ArrayList<>()).add(word);
        }

        // turn the hashmap values into a List and return
        Set<String> anagramGroups = anagramsMap.keySet();
        List<List<String>> result = new ArrayList<>();

        for (String key : anagramGroups) {
            result.add(anagramsMap.get(key));
        }
        return result;
    }

    String orderChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
