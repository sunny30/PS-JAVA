package facebook.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestDistanceFromAllBuilding {
    int[] dx = {0,0,1,-1} ;
    int[] dy = {1,-1,0,0} ;

    class PD {
        int x;int y;int dis ;
        PD(int x,int y,int dis){
            this.x = x ;
            this.y = y ;
            this.dis = dis ;
        }
    }
    public int shortestDistance(int[][] grid) {
        int row = grid.length ;
        int col = grid[0].length ;
        int[][] dist = new int[row][col] ;
        int[][] reach = new int[row][col] ;
        int cnt = 0 ;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    cnt++ ;
                    bfs(i,j,dist,reach,grid) ;
                }
            }
        }

        int ans = Integer.MAX_VALUE ;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(reach[i][j]==cnt){
                    ans = Math.min(ans,dist[i][j]) ;
                }
            }
        }

        if(ans!=Integer.MAX_VALUE)
        return  ans ;
        else
            return -1 ;

    }


    public void bfs(int x,int y,int[][] dist,int[][] reach,int[][] grid){
        int row = grid.length ;
        int col = grid[0].length ;
        boolean[][] visited = new boolean[row][col] ;

        Queue<PD> queue = new ArrayDeque<PD>() ;
        queue.add(new PD(x,y,0)) ;
        while (!queue.isEmpty()){

            PD p = queue.poll() ;
            int rx = p.x ;
            int ry = p.y ;
            int rd = p.dis ;
            visited[rx][ry] = true ;
            for(int i=0;i<4;i++){
                int xx = rx+dx[i] ;
                int yy = ry+dy[i] ;
                int dd = rd+1 ;

                if(xx>=0 && xx<row && yy>=0 && yy<col && grid[xx][yy]==0 && !visited[xx][yy]){
                    reach[xx][yy]++ ;
                    dist[xx][yy]+=dd ;
                    visited[xx][yy] = true ;
                    queue.add(new PD(xx,yy,dd)) ;
                }
             }


        }



    }

}
