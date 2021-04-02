package leetcodeuber;

public class SearchIn2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length ;
        int cols = matrix[0].length ;

        int fs = 0 ;
        int ls = cols-1 ;

        while (fs<rows &&ls>=0){
            if(matrix[fs][ls]==target)
                return true ;
            if(matrix[fs][ls]>target)
                ls-- ;
            else if(fs+1<rows && matrix[fs][ls]>target && matrix[fs+1][ls]<target)
            {
                fs++ ;
                ls-- ;
            }else{
                fs++;
            }
        }
        return false ;


    }


}
