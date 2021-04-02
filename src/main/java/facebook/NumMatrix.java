package facebook;

public class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        init();
    }
    public void init(){
        int rows = matrix.length ;
        int cols = 0 ;
        if(rows>0)
            cols = matrix[0].length ;

        for(int  i =0 ;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i>0)
                    matrix[i][j] +=matrix[i-1][j] ;

            }
        }

        for(int  i =0 ;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j>0)
                    matrix[i][j]+=matrix[i][j-1] ;

            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = matrix[row2][col2]-((row1>0 && col2>=0)?matrix[row1-1][col2]:0)-((row2>=0 && col1>0)?matrix[row2][col1-1]:0) ;
            ans = ans + ((row1>0 && col1>0)?matrix[row1-1][col1-1]:0) ;
            return ans ;
    }

    public static void main(String[] args) {
        int [][] matrix = {

                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}

        } ;
        NumMatrix matrix1 = new NumMatrix(matrix) ;
        System.out.println(matrix1.sumRegion(2, 1, 4, 3)) ;

    }
}
