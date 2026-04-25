class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;

        // Check if the first row has a zero
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                columnHasZero = true;
                break;
            }
        } 

        // Check if the first column has a zero
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                rowHasZero = true;
                break;
            }

        }

        // Check for zeroes in the rest of the array
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // Nullify rows based on values in first column
        for(int row = 1; row < matrix.length; row++){
            if(matrix[row][0] == 0) nullifyRow(matrix, row);
        }

        // Nullify columns based on values in first rows
        for(int column = 1; column < matrix[0].length; column++){
            if(matrix[0][column] == 0) nullifyColumn(matrix, column);
        }

        // Nullify first row
        if(rowHasZero) nullifyRow(matrix, 0);

        // Nullify first column
        if(columnHasZero) nullifyColumn(matrix, 0);

    }

    private void nullifyColumn(int[][] matrix, int column){
        for(int r = 0; r < matrix.length; r++){
            matrix[r][column] = 0;
        }
    }

    private void nullifyRow(int[][] matrix, int row){
        for(int col = 0; col < matrix[0].length; col++){
            matrix[row][col] = 0;
        }
    }
}

/**
 First solution : using O(MxN) space
 -> keeping the zero cells coordinates in an array
 public void setZeroes(int[][] matrix) {
        List<List<Integer>> coordinates = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0) coordinates.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        for(int c = 0; c < coordinates.size(); c++){
            int row = coordinates.get(c).get(0);
            int column = coordinates.get(c).get(1);
            for(int col = 0; col < matrix[0].length; col++){
                matrix[row][col] = 0;
            }
            for(int r = 0; r < matrix.length; r++){
                matrix[r][column] = 0;
            }
        }
    }
 */

 /**
    Second solution : using O(M+N) space
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for(int row : rows){
            for(int col = 0; col < matrix[0].length; col++){
                matrix[row][col] = 0;
            }
        }
        for(int column : columns){
            for(int r = 0; r < matrix.length; r++){
                matrix[r][column] = 0;
            }
        }
    }
  */