package zendrive;

public class Solution {

    public void spiral(int[][] input,int rowstart,int rowend,int colstart,int colend){
        int row = input.length ;
        int col = input[0].length ;
        if(rowstart>rowend || colstart>colend || rowstart==row || colstart==col)
            return ;
        for(int i=colstart;i<=colend;i++){
            System.out.print(input[rowstart][i]+" ");
        }
        if(rowstart+1<row)
        for(int i=rowstart+1;i<=rowend;i++){
            System.out.print(input[i][colend]+" ");
        }
        if(rowstart!=rowend)
        for(int i=colend-1;i>=colstart;i--){
            System.out.print(input[rowend][i]+" ");
        }
        if(colstart!=colend)
        for(int i=rowend-1;i>rowstart;i--){
            System.out.print(input[i][colstart]+" ");

        }

       // System.out.println();
        spiral(input,rowstart+1,rowend-1,colstart+1,colend-1);


    }

    public static void main(String[] args) {
        int[][] a = {
                    {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}


        } ;

        Solution solution = new Solution() ;
        solution.spiral(a,0,a.length-1,0,a[0].length-1);
    }
}
