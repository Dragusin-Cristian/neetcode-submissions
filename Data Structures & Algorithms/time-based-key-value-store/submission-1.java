class TimeMap {
    public record Item (HashMap<Integer, String> valuesMap, List<Integer> timestamps) {};

    HashMap<String, Item> items;

    public TimeMap() {
        items = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        // create the valuesMap and timestamps if doesn't exist
        if (items.get(key) == null) {
            items.put(key, new Item(
                new HashMap<Integer, String>(),
                new ArrayList<Integer>()
            ));
        }
        Item item = items.get(key);

        // add to the values (consider we won't edit existing timestamps, only add)
        item.valuesMap.put(timestamp, value);
        item.timestamps.add(timestamp);
    }
    
    public String get(String key, int timestamp) {
        // find the item in items
        if (items.get(key) == null) {
            return "";
        }
        Item item = items.get(key);
        List<Integer> ts = item.timestamps;
        int resultTs = -1;

        // edge cases: ts has lemgth 1
        if (ts.size() == 1) {
            if (timestamp >= ts.get(0)) {
                return item.valuesMap.get(ts.get(0));
            } else {
                return "";
            }
        }


        // binarysearch on timestamps to find the matching or lower timestamp
        int start = 0, end = ts.size() -1;

        while (start <= end) {
            int m = start + (end - start)/2;

            // case when timestamp exists
            // if (timestamp == ts.get(m)) {
            //     resultTs = timestamp;
            //     break;
            // }
            // case when timestamp doesn't exist
            // but timestamp > [m] && timestamp < [m+1]
            // return ts[m]
            if (timestamp >= ts.get(m)) {
                if ((m+1 < ts.size() && timestamp < ts.get(m+1)) 
                    || m+1 >= ts.size()) {
                    resultTs = ts.get(m);
                    break;
                }
            }

            if (timestamp < ts.get(m)) {
                end = m-1;
            }

            if (timestamp > ts.get(m)) {
                start = m+1;
            }
        }

        // use the timestamp to get value from valuesMap
        if (resultTs == -1) {
            return "";
        }
        return item.valuesMap.get(resultTs);
    }
}
