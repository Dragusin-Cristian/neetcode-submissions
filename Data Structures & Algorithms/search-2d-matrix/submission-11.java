class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Binary search for the rows to find the row
        int rowIndex = findRow(matrix, target);
        if (rowIndex == -1) {
            return false;
        }

        // Binary search inside the row
        int[] nums = matrix[rowIndex];
        int start = 0, end = nums.length -1;

        while (start <= end) {
            // find the middle
            int m = start + (end - start)/2;

            // if middle = target, return true
            if (target == nums[m]) {
                return true;
            }

            // if target > middle, start = middle +1
            if (target > nums[m]) {
                start = m +1;
            }

            // if target < middle, end = middle -1
            if (target < nums[m]) {
                end = m -1;
            }
        }

        return false;
    }

    int findRow(int[][] matrix, int target) {
        int rowN = matrix[0].length -1;

        int startRow = 0, endRow = matrix.length -1;

        while (startRow <= endRow) {
            // find the middle row
            int middleRowIndex = startRow + (endRow - startRow)/2;
            int[] middleRow = matrix[middleRowIndex];

            // if target is in middle row, return middleRow
            if (target >= middleRow[0] && target <= middleRow[rowN]) {
                return middleRowIndex;
            }

            // if target > middleRow[rowN], startRow = middleRow + 1
            if (target > middleRow[rowN]) {
                startRow = middleRowIndex +1;
            }

            // if target < middleRow[0], ednRow = middleRow -1
            if (target < middleRow[0]) {
                endRow = middleRowIndex -1;
            }
        }

        return -1;
    }
}
