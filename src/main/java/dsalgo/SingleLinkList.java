package dsalgo;

class Node{
    int val ;
    Node next ;

    Node(int val){
        this.val =val ;
        this.next = null;
    }
}
public class SingleLinkList {
    Node root ;
    Node tail ;
    SingleLinkList(Node root){
        this.root =root ;
        this.tail = root ;
    }

    public void append(int val){
        Node newNode = new Node(val) ;
        tail.next = newNode ;
        tail=newNode;
    }

    public Node reverese(Node root,Node parent){
        if(root==null){
            Node temp = this.root ;
            this.root =tail ;
            tail = temp ;
            return parent ;
        }
        if(root.next==null) {
            Node temp = this.root ;
            this.root =tail ;
            tail = temp ;
            root.next=parent ;
            return root;
        }

        Node first = root ;
        Node second = root.next ;
        Node third = second.next ;
        first.next = parent ;
        second.next =first ;
        reverese(third,second) ;

        return second ;
    }


    public static void main(String[] args) {
        SingleLinkList linkList = new SingleLinkList(new Node(3)) ;
        linkList.append(4);
        linkList.append(5);
        linkList.append(6);
      //  linkList.append(7);
        Node temp = linkList.root;
        while(temp!=null){

            System.out.println(temp.val);
            temp = temp.next;
        }
        linkList.reverese(linkList.root,null);
        temp = linkList.root ;
        while(temp!=null){

            System.out.println(temp.val);
            temp = temp.next;
        }



    }



}
