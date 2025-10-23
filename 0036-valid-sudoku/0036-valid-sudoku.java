class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int N = 9;

        int[] rows = new int[N];
        int[] columns = new int[N];
        int[] boxes = new int[N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){

                if(board[i][j] == '.') continue;

                int val = board[i][j] - '0';
                int pos = 1 << (val - 1);

                if((rows[i] & pos) > 0) return false;
                rows[i] |= pos;

                if((columns[j] & pos) > 0) return false;
                columns[j] |= pos;

                int index = (i/3) * 3 + j/3;
                if((boxes[index] & pos) > 0) return false;
                boxes[index] |= pos;
            }
        }

        return true;
    }
}

/* HashSet Approach
public boolean isValidSudoku(char[][] board) {
        final int N = 9;

        HashSet<Character>[] rows = new HashSet[N]; 
        HashSet<Character>[] columns = new HashSet[N]; 
        HashSet<Character>[] subgrids = new HashSet[N]; 

        for(int i = 0; i < N; i++){
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            subgrids[i] = new HashSet<Character>();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                char val = board[i][j];
                if(val == '.') continue;

                if (rows[i].contains(val)) return false;
                rows[i].add(val);

                if (columns[j].contains(val)) return false;
                columns[j].add(val);

                int subgridIndex = (i/3) * 3 + j/3;
                if (subgrids[subgridIndex].contains(val)) return false;
                subgrids[subgridIndex].add(val);
            }
        }

        return true;
    }
*/