package lld;

import java.util.ArrayList;
import java.util.List;

public class Player {



    private PieceEnum playersSymbol ;
    private String name ;
    private List<Location> moves = new ArrayList<Location>() ;

    Player(PieceEnum pieceEnum,String name){
        this.name = name ;
        this.playersSymbol = pieceEnum ;
    }


    public void addMove(Location location){
        this.moves.add(location);
    }

    public PieceEnum getPlayersSymbol() {
        return playersSymbol;
    }

    public void setPlayersSymbol(PieceEnum playersSymbol) {
        this.playersSymbol = playersSymbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
