package dsalgo;

class LNode{
    int val ;
    LNode next ;
    LNode prev ;

    LNode(int val){
        this.val = val ;
        this.next = null ;
        this.prev = null ;
    }
}

class LinkList{
    LNode start ;
    LNode end ;

    LinkList(LNode root) {
        this.start = root ;
        this.end = root ;
    }

    public void append(int val){
        LNode newNode = new LNode(val) ;
        end.next = newNode ;
        newNode.prev = end ;
        end = newNode ;
    }

    public void remove(LNode node){
        if(node.next==null && node.prev==null)
            return ;
        if(node!=start)
            node.prev.next = node.next ;
        if(node!=end)
            node.next.prev = node.prev ;
        if(node==start)
            start = start.next ;
        if(node==end)
            end = end.prev ;
        node.next =null ;
        node.prev=null ;
    }

    public void printList(){
        LNode temp = start ;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next ;
        }
    }
}

public class DoubleLLImpl {

    public static void main(String[] args) {
        LNode root = new LNode(3) ;
        LinkList linkList = new LinkList(root) ;
        linkList.append(5);
        linkList.append(7);
        linkList.append(9);
        linkList.printList();
        linkList.remove(root);
        linkList.remove(linkList.end);
        linkList.printList();
    }


}
