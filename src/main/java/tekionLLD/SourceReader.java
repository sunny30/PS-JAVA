package tekionLLD;

public class SourceReader {

    Connection connection ;
    String waterMark ;
    String lastTime ;
    String customeName ;




    SourceReader(Connection connection,String waterMark,String lastTime){
        this.connection = connection ;
        this.waterMark = waterMark ;
        this.lastTime = lastTime ;
    }

    public void readSource(){
        connection.getReadQueries(waterMark,lastTime,customeName) ;

    }


}
