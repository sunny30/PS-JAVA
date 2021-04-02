package tekionLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Config {

    List<String> dealers = new ArrayList<String>();
    HashMap<String,List<String>> customTransformations = new HashMap<String, List<String>>() ;
    HashMap<String,HashMap<String, String>> sourceConnections = new HashMap<String,HashMap<String, String>>() ;
    HashMap<String, HashMap<String,String> > targetConeections  = new HashMap<String,HashMap<String,String>>() ;



    public void addDealer(String dealer){
        dealers.add(dealer);
    }

    public void addCustomTrasformations(String dealerId,String transformation){
        customTransformations.get(dealerId).add(transformation);
    }

    public void updateCompleteTransformations(String dealerId,List<String> transformations){
        customTransformations.put(dealerId,transformations) ;
    }
    //key will be "dealer,connectionId"
    public void updateSourceSourceConnections(String dealerAndConnectionId,HashMap<String,String> connections){
        sourceConnections.put(dealerAndConnectionId,connections) ;
    }

    public void updateTargetConnections(String dealerAndConnectionId,HashMap<String,String> connections){
        targetConeections.put(dealerAndConnectionId,connections) ;
    }


}
