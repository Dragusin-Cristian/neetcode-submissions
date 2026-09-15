class Solution {
    public boolean isAnagram(String s, String t) {
        return sortLetters(s).equals(sortLetters(t));
    }

    String sortLetters(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        return new String(characters);

    }
}
