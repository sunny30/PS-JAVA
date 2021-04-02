public class Exe1Task implements Runnable{

    public Exe1Task(int id){
        this.id = id ;
    }
    private int id ;

    public int getId(){
        return this.id ;
    }

    public void inc(){
        this.id++ ;
    }

    public void run(){
        this.inc() ;
        System.out.println(this.id);
    }
}
