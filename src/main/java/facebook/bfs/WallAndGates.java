package facebook.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class WallAndGates {
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
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length ;
        int col = rooms[0].length ;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rooms[i][j]==0){
                    bfs(i,j,rooms) ;
                }
            }
        }


    }

    void bfs(int x,int y,int[][] rooms){

        int row = rooms.length ;
        int col = rooms[0].length ;
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

                if(xx>=0 && xx<row && yy>=0 && yy<col && rooms[xx][yy]>0 && !visited[xx][yy]){
                    rooms[xx][yy] = Math.min(rooms[xx][yy],dd) ;
                    visited[xx][yy] = true ;
                    queue.add(new PD(xx,yy,dd)) ;
                }
            }


        }


    }
}
