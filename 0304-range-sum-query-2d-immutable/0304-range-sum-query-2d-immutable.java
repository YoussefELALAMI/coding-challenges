class NumMatrix {

    int[][] data;
    public NumMatrix(int[][] matrix) {
        this.data = matrix;
        this.getPrefixSum();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = 0;
        for (int i = row1; i <= row2; i ++){
            if (col1 != 0) total += (data[i][col2] - data[i][col1-1]);
            else total += data[i][col2];
        }
        return total;        
    }

    private void getPrefixSum() {
        for (int i = 0; i < this.data.length; i++){
            for (int j = 1; j < this.data[i].length; j ++){
                data[i][j] += data[i][j-1];
            }
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */