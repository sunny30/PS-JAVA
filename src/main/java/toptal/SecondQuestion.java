package toptal;

public class SecondQuestion {

    public int[] backTrack(int[][] dp,int[][] parent,int len,int[] sol,int[] in){



            int c = parent[6][len] ;

        if(c==len){
            sol[c]++ ;
            return  sol ;
        }
            sol[c]++ ;
            return backTrack(dp,parent,len-in[c],sol,in) ;

    }


    int[] getChange(Double m, Double p) {

        Double tc = m * 100;
        Double tp = p * 100;


        int a = Integer.parseInt(tc.toString());
        int b = Integer.parseInt(tp.toString());

        int[] in = {5, 10, 25, 50, 100};
        int[][] dp = new int[10][a - b + 1];
        int[][] parent = new int[10][a - b + 1];





        for (int i = 1; i < a - b + 1; i++) {
            dp[0][i] = i;
            parent[0][i] = 0;
        }

        for (int i = 1; i < 6; i++) {

            for (int j = 0; j <= a - b; j++) {

                if (j == in[i - 1]) {
                    dp[i][j] = 1;
                    parent[i][j] = i;
                } else if (j > in[i - 1]) {
                    if (dp[i][j - in[i - 1]] + 1 < dp[i - 1][j]) {

                        dp[i][j] = dp[i][j - in[i - 1]] + 1;
                        parent[i][j] = parent[i][j - in[i - 1]];

                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                    parent[i][j] = parent[i - 1][j];
                }


            }


        }
        int[] sol = new int[6] ;
        return backTrack(dp,parent,a-b,sol,in) ;


    }


    public static void main(String[] args) {
        SecondQuestion secondQuestion = new SecondQuestion() ;
        int [] ans = secondQuestion.getChange(5.0,.99) ;

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
