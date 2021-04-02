package lld;

public abstract class Board {

    private int numPlayers ;



    private int dimension ;
    private int numMoves ;

    public abstract void makeMove(Location location) ;

    public abstract boolean winSat(Location location) ;

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getNumMoves() {
        return numMoves;
    }

    public void setNumMoves(int numMoves) {
        this.numMoves = numMoves;
    }
}
