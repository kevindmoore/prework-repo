public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int numColumns = (A*2)-1;
        int number = A;
        ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
        int result[][] = new int[numColumns][numColumns];
        for (int i=0; i < numColumns; i++) {
            result[i] = new int[numColumns];
            ArrayList<Integer> row = new ArrayList<Integer>();
            solution.add(row);
         }
        int startValue = A;
        int currentColumnSize = numColumns;
        int startRow = 0;
        int endRow = numColumns-1;
        int startColumn = 0;
        int endColumn = numColumns-1;
        for (int i=0; i < A; i++) {
            // System.out.println("i=" + i);
            for (int j=startRow; j <= endRow; j++) {
                // System.out.println("j=" + j);
                // ArrayList<Integer> row = solution.get(j);
                for (int k=startColumn; k <= endColumn; k++) {
                    // System.out.println("k=" + k);
                    if (j == startColumn || j == endColumn) {
                        result[j][k] = startValue;
                        // System.out.println("Setting result[" + j + "][" + k + "] to " + startValue);
                        // row.add(startValue);
                    } else if (k == startColumn || k == endColumn) {
                        // row.add(startValue);
                        // System.out.println("Setting result[" + j + "][" + k + "] to " + startValue);
                        result[j][k] = startValue;
                    }
                }
            }
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
            currentColumnSize--;
            startValue--;
        }
        for (int j=0; j < numColumns; j++) {
            ArrayList<Integer> row = solution.get(j);
            for (int k=0; k < numColumns; k++) {
                row.add(result[j][k]);
            }
        }
       return solution;
        // return new ArrayList<Integer>(Arrays.asList(result));
    }
}
