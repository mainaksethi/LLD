public class Move {
    private Piece piece;
    private Position from_position;
    private Position to_position;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getFrom_position() {
        return from_position;
    }

    public void setFrom_position(Position from_position) {
        this.from_position = from_position;
    }

    public Position getTo_position() {
        return to_position;
    }

    public void setTo_position(Position to_position) {
        this.to_position = to_position;
    }

    public Move(Piece piece, Position from_position, Position to_position) {
        this.piece = piece;
        this.from_position = from_position;
        this.to_position = to_position;
    }
}
