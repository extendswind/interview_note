package codingInterviews;

import org.junit.Assert;


public class _4FindNumIn2DArray {
    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if(matrix.length == 0)
                return false;
            // 从左下角开始
            int row = matrix.length - 1;
            int col = 0;
            while(col < matrix[0].length && row >= 0) {
                if (target == matrix[row][col])
                    return true;
                if (target > matrix[row][col]) {
                    col++;
                } else {
                    row--;
                }
            }
            return false;
        }
    }

    public static void main(String[] argvs){
        Solution s = new Solution();
        int[][] nums = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        Assert.assertTrue(s.findNumberIn2DArray(nums, 5));
        Assert.assertFalse(s.findNumberIn2DArray(nums, 20));


    }
}
