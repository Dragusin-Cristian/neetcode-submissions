class Solution {
    public boolean isAnagram(String s, String t) {
        // return sortLetters(s).equals(sortLetters(t));

        HashMap<Integer, Integer> freqMap = new HashMap();
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();

        for (char c : sArr) {
            if (freqMap.get((int) c) == null) {
                freqMap.put((int) c, 1);
            } else {
                freqMap.merge((int) c, 1, Integer::sum);
            }
        }

        for (char c : tArr) {
            if (freqMap.get((int) c) == null || freqMap.get((int) c) == 0) {
                return false;
            } else {
                freqMap.merge((int) c, 1, (currV, v) -> currV - v); // ?
            }
        }

        for (char c : sArr) {
            if (freqMap.get((int) c) != 0) {
                return false;
            }
        }

        return true;
    }





    String sortLetters(String word) {
        char[] characters = word.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
