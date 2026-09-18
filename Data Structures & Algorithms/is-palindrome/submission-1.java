class Solution {
    public boolean isPalindrome(String s) {


        String sNew = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int l = 0, r = sNew.length()-1;

        while (l < r) {

            if (sNew.charAt(l) != sNew.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;

        // List<Character> sList = new ArrayList<>();
        // List<Character> sListReversed = new ArrayList<>();
        
        // // trimm empty spaces
        // for (Character c : s.trim().toLowerCase().toCharArray()) {
        //     if (isAlphanumeric(c)) {
        //         sList.add(c);
        //     }
        // }

        // // order inverse
        // for (int i = sList.size()-1; i >=0; i--) {
        //     sListReversed.add(sList.get(i));
        // }

        // // compare
        // for (int i = 0; i < sList.size(); i++) {
        //     if (sList.get(i) != sListReversed.get(i)) {
        //         return false;
        //     }
        // }

        // return true;
    }

    // boolean isAlphanumeric(Character c) {
    //     return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    // }
}
