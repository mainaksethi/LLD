public class Piece {

    private PieceType pieceType;

    private Color color;

    private boolean isKilled = false;

    public Piece(PieceType pieceType, Color color, boolean isKilled) {
        this.pieceType = pieceType;
        this.color = color;
        this.isKilled = isKilled;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }
}
