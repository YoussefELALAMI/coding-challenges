class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    private void transpose(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int column = row + 1; column < matrix[row].length; column++){
                if(column > row){
                    int temp = matrix[row][column];
                    matrix[row][column] = matrix[column][row];
                    matrix[column][row] = temp;
                }
            }
        }
    }

    private void reverse(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            int left = 0, right = matrix[row].length - 1;
            while (right > left) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                right--;
                left++;
            }
        }
    }
}