package facebook;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length ;

        int col = obstacleGrid[0].length ;

        int[][] dp= new int[row][col] ;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){

                if(i==0 && j==0 && obstacleGrid[i][j]!=0)
                    dp[0][0] = 1 ;
                else if(i==0 && j==0 && obstacleGrid[i][j]==1)
                    dp[0][0] = 0 ;
                else{
                    if(obstacleGrid[i][j]==1)
                        dp[i][j] = 0 ;
                    else{
                        dp[i][j] =( (i>0)?dp[i-1][j]:0) ;
                        dp[i][j] = dp[i][j] + ( (j>0)?dp[i][j-1]:0) ;
                    }
                }

            }
        }
        return dp[row-1][col-1] ;
    }
}
