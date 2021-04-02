package facebook;

import leetcodeuber.GenerateParenthesies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllPermutation {
    List<List<Integer>> anscollection = new ArrayList<List<Integer>>() ;
    public void genPermutation(int[] nums,boolean[] visited,int index,Integer[] ans,int len){
        if(len==nums.length){
            List<Integer> temp = new ArrayList<Integer>() ;
            for(int i=0;i<ans.length;i++)
                temp.add(ans[i]);
            anscollection.add(temp);
            return ;
        }



        visited[index] =true ;
        for(int i=0;i<nums.length;i++){
            if(!visited[i]) {
                visited[i] = true ;
                ans[len] = (nums[i]) ;
                genPermutation(nums,visited,i,ans,len+1);
               // ans = Arrays.asList(new Integer[nums.length]) ;
                visited[i] =false ;
            }
        }
        visited[index]=false;

    }
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length ;
        boolean[] visited = new boolean[len] ;
        Integer[] ans = new Integer[nums.length] ;
        for(int i=0;i<len;i++)
            visited[i] = false ;
        for(int i=0;i<len;i++){
            ans[0] = nums[i] ;
            genPermutation(nums,visited,i,ans,1);

            visited[i] =false ;
        }
        return anscollection ;
    }

    public static void main(String[] args) {
        GenerateAllPermutation generateParenthesies = new GenerateAllPermutation() ;
        int[] nums = {4,6 ,5 ,1} ;
        generateParenthesies.permute(nums) ;
        for(int i=0;i<generateParenthesies.anscollection.size();i++){
            for(int j=0;j< generateParenthesies.anscollection.get(i).size();j++)
                System.out.print(generateParenthesies.anscollection.get(i).get(j));
            System.out.println();
        }
    }
}
