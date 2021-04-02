package tekionLLD;

public class SourceWriter {

    Connection connection ;
    CustomTransformation transformation ;

    SourceWriter(Connection connection,CustomTransformation transformation){
        this.connection = connection ;
        this.transformation = transformation ;
    }


    public void exportData(){

        System.out.println("write to DB");

    }
}
