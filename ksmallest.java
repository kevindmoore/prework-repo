public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        Map<Integer, Integer> sorted = new TreeMap<Integer, Integer>();
        for (Integer item : A) {
            if (sorted.containsKey(item)) {
                sorted.put(item, sorted.get(item)+1);
            } else {
                sorted.put(item, 1);
            }
        }
        int count = 0;
        int maxValue = 0;
        for (Integer key : sorted.keySet()) {
            // System.out.println("key:" + key + " count = " + count);
            count += sorted.get(key);
            if (key > maxValue) {
                maxValue = key;
            }
            // System.out.println("maxValue:" + maxValue);
            if (count >= B) {
                break;
            }
        }
        return maxValue;
    }
}
