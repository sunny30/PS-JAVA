package facebook;

public class WordSearch {

    public boolean dfs(char[][] board, String word, int rc, int colc, boolean[][] visited, int pos) {
        if (pos == word.length()-1)
            return true;
        int row = board.length;
        int col = board[0].length;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        boolean ans = false;
        visited[rc][colc] = true ;
        for (int i = 0; i < 4; i++) {
            int xrow = rc + dx[i];
            int xcol = colc + dy[i];
            if (xrow >= 0 && xrow < row && xcol >= 0 && xcol < col && visited[xrow][xcol] == false && board[xrow][xcol] == word.charAt(pos+1)) {
                visited[xrow][xcol] = true;
                ans = ans || dfs(board, word, xrow, xcol, visited, pos + 1);
                visited[xrow][xcol] = false;
            }


        }
        return ans;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    ans = ans || dfs(board, word, i, j, visited, 0);
                    visited[i][j] =false ;
                }
            }
        }
        return ans;
    }
}
