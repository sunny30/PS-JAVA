package lld;

import java.util.List;

public class TicTacToeBoard extends Board {

    private PieceEnum[][] ttboard;
    private Player[] players;



    private boolean isWinSat ;

    TicTacToeBoard(int numPlayers, int dimension, Player p1, Player p2) {
        this.setDimension(dimension);
        this.setNumMoves(0);
        this.setNumPlayers(numPlayers);
        ttboard = new PieceEnum[dimension + 1][dimension + 1];
        init();
        players = new Player[numPlayers];
        players[0] = p1;
        players[1] = p2;
        isWinSat = false ;
    }

    public void init() {
        for (int i = 0; i <= getDimension(); i++) {
            for (int j = 0; j <= getDimension(); j++) {
                ttboard[i][j] = PieceEnum.EMPTY;
            }
        }
    }

    public void makeMove(Location location) {
        int dim = this.getDimension();
        int x = location.getX();
        int y = location.getY();
        if (x >= 1 && x <= dim && y >= 1 && y <= dim && ttboard[x][y] == PieceEnum.EMPTY) {
            ttboard[x][y] = location.getSymbol();
            players[getNumMoves() % getNumPlayers()].addMove(location);
            setNumMoves(getNumMoves() + 1);

            if(winSat(location)){
                System.out.println(location.getSymbol().toString()+" Has won");
            }

        } else {
            throw new IllegalArgumentException("Bad moves");
        }

    }

    @Override
    public boolean winSat(Location location) {

        int x = location.getX() ;
        int y = location.getY() ;
        int rc = 0 ;
        int cc =0 ;
        int diag = 0 ;
        int revdig = 0 ;
        for(int i=1;i<=getDimension();i++){
            if(ttboard[x][i]==location.getSymbol()){
                rc++ ;
            }
            if(ttboard[i][y]==location.getSymbol())
                cc++ ;
            if(ttboard[i][i]==location.getSymbol())
                diag++ ;
            if(ttboard[i][getDimension()-i+1]==location.getSymbol())
                revdig++ ;
        }

        if(cc==getDimension() || rc == getDimension() || diag == getDimension() || revdig == getDimension())
            return true ;
        return false ;
    }


    public void setWinSat(boolean winSat) {
        isWinSat = winSat;
    }

    public boolean getWinSat(){
        return this.isWinSat ;
    }
}
