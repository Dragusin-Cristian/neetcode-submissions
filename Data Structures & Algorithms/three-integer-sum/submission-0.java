class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();

        // edge cases: nums length < 3

        for (int i = 0; i < sorted.length; i++) {
            // if positive or duplicate, skip
            if (sorted[i] > 0 || (i > 0 && sorted[i-1] == sorted[i])) {
                continue;
            }

            // twoSum for next elements:

            // abs of sorted[i] becomes target
            int target = Math.abs(sorted[i]);

            // create diffsMap
            Map<Integer, Integer> diffsMap = new HashMap<>();
            for (int j = i+1; j < sorted.length; j++) {
                diffsMap.put(target-sorted[j], j);
            }

            // find pair in map sorted[j]
            Set<Integer> added = new HashSet<>();
            for (int j = i+1; j < sorted.length; j++) {
                added.add(j);
                if (diffsMap.get(sorted[j]) != null
                && !added.contains(diffsMap.get(sorted[j]))) {
                    result.add(new ArrayList<>(List.of(
                        sorted[i], sorted[j], sorted[diffsMap.get(sorted[j])]
                    )));
                    added.add(diffsMap.get(sorted[j]));
                }
            }
        }

        return result;
    }

}
