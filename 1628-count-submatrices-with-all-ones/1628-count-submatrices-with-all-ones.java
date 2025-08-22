class Solution {
    private int countSubarraysOfOnes(int[] rowMask) {
        int consOne = 0;
        int count = 0;

        for (int i = 0; i < rowMask.length; i++) {
            if (rowMask[i] != 1) {
                consOne = 0;
            } else {
                consOne++;
            }
            count += consOne;
        }
        return count;
    }

    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int totalCount = 0;

        for (int startRow = 0; startRow < rows; startRow++) {

            int[] rowMask = new int[cols];
            for (int i = 0; i < cols; i++) {
                rowMask[i] = 1;
            }

            for (int endRow = startRow; endRow < rows; endRow++) {

                for (int col = 0; col < cols; col++) {
                    rowMask[col] = rowMask[col] & mat[endRow][col];
                }
                totalCount += countSubarraysOfOnes(rowMask);
            }
        }
        return totalCount;
    }
}