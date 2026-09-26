class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l = 0;
        int r = rows * cols - 1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int midEle = matrix[mid/cols][mid%cols];

            if(midEle == target){
                return true;
            }

            if(midEle < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
    return false;
    }
}
