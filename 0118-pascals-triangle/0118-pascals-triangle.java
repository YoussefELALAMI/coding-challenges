class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        for(int row = 1; row < numRows; row++){
            List<Integer> currRow = new ArrayList<>();
            for(int col =  0; col <= triangle.get(row-1).size(); col++){
                if(col == 0 || col==row) currRow.add(1);
                else{
                    currRow.add(triangle.get(row-1).get(col-1) + triangle.get(row-1).get(col));

                }
            }
            triangle.add(currRow);
        }
        return triangle;
    }
}