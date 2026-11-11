class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int firstRow = 0;
        int firstColumn = 0;
        int lastRow = rows - 1;
        int lastColumn = columns - 1;
        while (results.size() < rows * columns) {
            for(int i = firstColumn; i <= lastColumn; i++){
                results.add(matrix[firstRow][i]);
            }
            for(int i = firstRow + 1; i <= lastRow; i++){
                results.add(matrix[i][lastColumn]);
            }
            if(firstRow != lastRow){
                for(int i = lastColumn - 1; i >= firstColumn; i--){
                    results.add(matrix[lastRow][i]);
                }
            }
            if(firstColumn != lastColumn){
                for(int i = lastRow - 1; i > firstRow; i--){
                    results.add(matrix[i][firstColumn]);
                }
            }
            firstColumn++;
            lastColumn--;
            firstRow++;
            lastRow--;
        }
        return results;
    }
}