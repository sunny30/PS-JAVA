package facebook;

public class NumIslands {

    public void dfs(char[][] grid,boolean[][] visited,int rc,int colc,int row,int col){
        int[] dx = {1,0,0,-1} ;
        int[] dy = {0,1,-1,0} ;
        visited[rc][colc]=true ;
        for(int i=0;i<4;i++){
            int xrow = rc+dx[i] ;
            int xcol = colc+dy[i] ;

            if(xrow>=0 && xrow<row && xcol>=0 && xcol<col && !visited[xrow][xcol] && grid[xrow][xcol]=='1'){
                dfs(grid,visited,xrow,xcol,row,col) ;
            }
        }
    }

    public int numIslands(char[][] grid) {
        int cnt = 0 ;
        int row = grid.length ;
        int col = grid[0].length ;
        boolean[][] visited = new boolean[row][col] ;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                visited[i][j] = false ;
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    ++cnt ;
                    dfs(grid,visited,i,j,row,col) ;
                }
            }
        }

        return cnt ;
    }
}
