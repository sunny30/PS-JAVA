package concurrency;

public class FirstTask implements Runnable{
    String name ;
    int inc ;
    static int count ;
    FirstTask(int name,int inc){
        this.name = String.valueOf(name) ;
        this.inc =inc ;
    }

    public void run() {

        for(int i=0;i<3;i++){
            System.out.println("before"+count);
            synchronized (FirstTask.class) {
                count = count + inc;
            }
            System.out.println(name+" "+count);
            try {
                if(name.equals("1"))
                    Thread.sleep(1000);
                else
                    Thread.sleep(600);
            }catch (Exception e){

            }

        }

    }
}
