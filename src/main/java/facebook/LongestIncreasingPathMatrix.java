package facebook;

public class LongestIncreasingPathMatrix {


    void dfs(int[][] matrix,int[][] dp,int rc,int colc,int rowLen,int colLen){

        int[] dx = {1,0,0,-1} ;
        int[] dy = {0,1,-1,0} ;
        dp[rc][colc] = 1 ;
        for(int i=0;i<dx.length;i++)
        {
            int xrow = rc+dx[i] ;
            int xcol = colc+dy[i] ;

            if(xrow>=0 && xrow<rowLen && xcol>=0 && xcol<colLen && matrix[xrow][xcol]<matrix[rc][colc]){
                if(dp[xrow][xcol]==0){
                     dfs(matrix,dp,xrow,xcol,rowLen,colLen);
                     dp[rc][colc] = Math.max(dp[rc][colc],1+dp[xrow][xcol]) ;
                }else{
                    dp[rc][colc] = Math.max(dp[rc][colc],1+dp[xrow][xcol]) ;
                }
            }
        }


    }

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length ;
        int col = matrix[0].length ;

        boolean[][] visited = new boolean[row][col] ;
        int[][] dp = new int[row][col] ;

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                dp[i][j] = 0 ;
        int ans = 1 ;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(dp[i][j]==0){
                    dfs(matrix,dp,i,j,row,col) ;
                }
                ans = Math.max(ans,dp[i][j]) ;
            }

        return ans ;

    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix increasingPathMatrix = new LongestIncreasingPathMatrix() ;
        int[][] matrx = {{9,9,4},{6,6,8},{2,1,1}} ;
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}} ;
        System.out.println(increasingPathMatrix.longestIncreasingPath(matrix)) ;
    }
}
