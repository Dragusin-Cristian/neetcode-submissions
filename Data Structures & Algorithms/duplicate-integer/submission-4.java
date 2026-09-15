class Solution {
    public boolean hasDuplicate(int[] nums) {
        boolean res = false;

        HashMap<Integer, Boolean> occMap = new HashMap<>();

        for (int num : nums) {
            if (occMap.get(num) == null) {
                occMap.put(num, true);
            } else {
                res = true;
                break;
            }
        }

        return res;
    }
}