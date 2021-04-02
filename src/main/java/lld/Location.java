package lld;

public class Location {


    private int x;
    private int y;



    private PieceEnum symbol;

    Location(int x, int y,PieceEnum symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol ;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PieceEnum getSymbol() {
        return symbol;
    }

    public void setSymbol(PieceEnum symbol) {
        this.symbol = symbol;
    }
}
