import java.util.List;
import java.util.Map;

public class GameManager {

    private Piece[][] board;

    private Map<SNLColor, SNLPlayer> colorPlayerMap;

    private List<Move> move_history;

    public void start() {
        while (true) {
            Move move = MoveManager.getMove();
            if (!isValidMove(move)) {
                continue;
            }
            make_move(move);
            move_history.add(move);
//            update_score_sheet();
        }
    }

    private void make_move(Move move) {
        Position toPosition = move.getTo_position();
        if (board[toPosition.getRow()][toPosition.getColumn()] != null) {
            Piece piece = board[toPosition.getRow()][toPosition.getColumn()];
            piece.setKilled(true);
        }
        board[toPosition.getRow()][toPosition.getColumn()] = move.getPiece();
    }

    private boolean isValidMove(Move move) {
        Position fromPosition = move.getFrom_position();
        Position toPosition = move.getTo_position();
        List<Position> positions = getPossiblePositions(move.getPiece());
        boolean positionFound = false;
        for (Position position: positions) {
            if (position.equals(toPosition)) {
                return true;
            }
        }
        return false;
    }

    private List<Position> getPossiblePositions(Piece piece) {
        // Returned for compiling the code
        return null;
    }

}