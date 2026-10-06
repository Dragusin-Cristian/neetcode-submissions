class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap to record the number of appearences of each number in nums
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int x : nums) {
            countMap.merge(x, 1, Integer::sum);
        }

        // get the highest k elements from the hashmap
        List<Map.Entry<Integer, Integer>> topK = countMap.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .limit(k)
        .toList();

        int[] result = new int[k];
        for (int i =0; i< k; i++) {
            result[i] = topK.get(i).getKey();
        }
        return result;
    }
}
