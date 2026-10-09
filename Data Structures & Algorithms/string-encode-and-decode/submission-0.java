class Solution {

    // ["Hello","Wor#ld"]
    public String encode(List<String> strs) {
        // return 5#Hello6#Wor#ld
        String result = "";
        for (String str : strs) {
            result += str.length() + "#" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        if (str.length() == 0) {
            return result;
        }

        int endIndex = 0;
        String countStr = str.split("#")[0];

        while (parsesToInt(countStr)) {
            // get the startIndex
            int startIndex = endIndex + countStr.length() + 1;

            // get the actual count and the endIndex
            int count = Integer.parseInt(countStr);
            endIndex = startIndex + count;

            // substring the word and add it to result
            String word = str.substring(startIndex, endIndex);
            result.add(word);

            // get the new countStr
            countStr = str.substring(endIndex).split("#")[0];
        }

        return result;
    }

    boolean parsesToInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }
}
