package facebook.linklist;

public class ReverseLinkList {

    static class LNode{
        int val ;
        LNode next ;
        LNode(int val,LNode next){
            this.val =val ;
            this.next = next ;
        }

        LNode(int val){
            this.val = val ;
            this.next = null ;
        }
    }

    public static LNode reverse(LNode prev,LNode current,LNode up){

        if(current==null)
            return prev ;
        if(up==null) {
            current.next =prev ;
            return current;
        }
        LNode sup = up.next ;
        current.next = prev ;
        return reverse(current,up,sup) ;


    }

    public static LNode Kreverse(LNode start,int k){
        int cnt = 1 ;
        if(start==null)
            return start ;
        LNode temp = start ;
        LNode ts = null ;
        LNode start1 = start ;
        LNode ts1 = null;
        LNode ans = null ;
        while (temp!=null){

           // temp = temp.next;
           // cnt++ ;
            if(cnt%k==0){
                LNode start2 = temp.next ;
                temp.next=null ;
                if(ts==null) {

                    ts = reverse(null, start, start.next);
                    ans = ts ;
                    ts1 = start ;

                }else {

                    ts = reverse(null, start1, start1.next);
                    ts1.next = ts ;
                    ts1 = start1 ;

                }
                start1=start2 ;
                temp =start2;
                //start=start2;

            }
            temp = temp.next;
            cnt++ ;
        }
        if(start1!=null) {
            ts = reverse(null, start1, start1.next);
            ts1.next = ts ;
            if(ans==null)
                ans = ts ;

        }
        return ans ;
    }


    public static void main(String[] args) {
        LNode lNode = new LNode(1,new LNode(2,new LNode(3,new LNode(4,new LNode(5,new LNode(6,null)))))) ;

        LNode temp =lNode ;
        while (temp!=null) {

            System.out.println(temp.val);
            temp = temp.next;
        }
       // LNode ns = reverse(null,lNode,lNode.next) ;

//        temp  = ns ;
//        while (temp!=null) {
//
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
        LNode kr = Kreverse(lNode,3);
        temp =kr ;
        while (temp!=null) {

            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
