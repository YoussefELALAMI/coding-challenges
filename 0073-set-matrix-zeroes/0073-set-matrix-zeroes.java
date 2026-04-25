class Solution {
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