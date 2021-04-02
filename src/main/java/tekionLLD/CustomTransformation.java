package tekionLLD;

import java.util.List;

public class CustomTransformation {

    List<String> customTransformations ;//sequence does matter

    TransformationEngine engine ;

    public CustomTransformation(List<String> customTransformations,TransformationEngine engine){
        this.customTransformations = customTransformations ;
        this.engine = engine ;
    }


    public void applyTransformations(){
        for(String s:customTransformations){
            String[] statements = s.split(",") ;
            engine.execute(statements[0],statements[1],statements[2],statements[3]);
        }
    }



}
