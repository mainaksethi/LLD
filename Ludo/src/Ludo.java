//import java.util.List;
//
//public class Ludo {
//    public static void main(String[] args) {
//
//    }
//}
//
///**
// * 1. Maximum 4 players playing game.
// * 2. Board is composed of many cells with different properties like home-cell, safe-cell.
// * 3. Every dice roll can result in following moves:
// *      a. Player choses to move one of the active pieces.
// *      b. If dice is 6 player can choose to spawn a piece.
// * 4. Every move starts with roll of a dice and results in below outcomes
// *      a. Player kills other piece.
// *      b. Player lands of a safe spot.
// *      c. Player has completed round and will move towards terminal-row.
// *      d. Player simply proceeds towards a new cell.
// *
// * 5. Same player is given another dice roll on below conditions:
// *      a. Dice roll is 6.
// *      b. A piece is killed by a player.
// *      c. Player enters home location.
// *
// */
//
//class GameManager {
//
//    private final LudoBoard board;
//    private final List<LudoPlayer> playersList;
//    private LudoDice dice;
//
//    public GameManager(LudoBoard board,
//                       List<LudoPlayer> playersList,
//                       LudoDice dice) {
//
//        this.board = board;
//        this.playersList = playersList;
//        this.dice = dice;
//    }
//
//    public startGame() {
//        while(!board.isGameOver()) {
//            Player player = getCurrentPlayer();
//            Integer value = dice.roll();
//            UIMove uiMove = LudoUIManager.getMove(player, value);
//            LudoPostMove postMove = board.makeMove(uiMove.piece, value);
//        }
//    }
//
//    private class LudoPostMove {
//        private boolean isSamePlayerChance;
//
//    }
//}
//
//class UIMove {
//    Piece piece;
//}
//
//class Piece {
//    private LudoColor color;
//    private boolean isActive;
//    private boolean reachedTerminal;
//    private LudoCell cell;
//}
//
//class LudoUIManager {
//
//}
//class LudoPlayer {
//
//    public LudoPlayer(String name, LudoColor color) {
//
//    }
//}
//
//enum LudoColor {
//    RED, BLUE, GREEN;
//}
//
//class LudoBoard {
//
//    List<LudoCell> cells;
//
//    public LudoPostMove makeMove(Piece piece, Integer diceRoll) {
//        if (validate()) {
//
//        }
//        // piece has to be spawned,
//    }
//
//    private class LudoCell {
//        private boolean isSafeCell;
//        private Integer index;
//        private boolean isBifurcatingCell;
//    }
//}
//
//class LudoDice {
//    public Integer roll() {
//
//    }
//}