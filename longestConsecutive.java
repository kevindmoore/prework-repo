public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        TreeMap<Integer,Integer> sorted = new TreeMap<Integer,Integer>();
        for (int i=0; i < A.size(); i++) {
            sorted.put(A.get(i), A.get(i));
            // System.out.println("Adding " + A.get(i));
        }
        int currentRunValue = -999999;
        int currentRun = 1;
        int longestRun = 1;
        for (Integer value : sorted.values()) {
            // System.out.println("currentRun " + currentRun + " value =" + value);
            if (currentRunValue == -999999) {
                // System.out.println("1:setting currentRun to " + value);
                currentRunValue = value;
            } else if (currentRunValue + 1 == value) {
                currentRun++;
                currentRunValue = value;
                // System.out.println("2:setting currentRun to " + currentRun + " currentRunValue = " + currentRunValue);
            } else {
                currentRunValue = value;
                if (currentRun > longestRun) {
                    longestRun = currentRun;
                    // System.out.println("3:setting longestRun to " + longestRun);
                }
                // System.out.println("4:setting currentRun to 1 currentRunValue = " + currentRunValue);
                currentRun = 1;
            }
        }
        if (currentRun > longestRun) {
            longestRun = currentRun;
        }
        return longestRun;
    }
}
