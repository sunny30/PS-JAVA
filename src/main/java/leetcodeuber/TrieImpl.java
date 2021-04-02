package leetcodeuber;

class Trie{
    int frequency ;
    Trie[] children ;

    public  Trie(){
        this.frequency = 1 ;
        children = new Trie[26] ;
        for(int i=0;i<26;i++){
            this.children[i] = null ;
        }
    }

    public void insert(Trie root,String str,int pos){
        if(pos>=str.length())
            return ;
        int pos1 = str.charAt(pos)-'a' ;
        if(root.children[pos1]==null){
            root.children[pos1] = new Trie() ;
        }else{
            root.children[pos1].frequency++ ;
        }
        insert(root.children[pos1],str,pos+1);
    }

    public void insert(String word) {
         insert(this,word,0);
    }




}

public class TrieImpl {

    public static void main(String[] args) {
        TrieImpl trie = new TrieImpl() ;
        Trie root = new Trie() ;
        root.insert("hello");
        System.out.println("hey");

    }

}
