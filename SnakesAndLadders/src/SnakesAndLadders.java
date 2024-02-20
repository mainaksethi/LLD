//import java.util.List;
//import java.util.Map;
//
//public class SnakesAndLadders {
//    public static void main(String[] args) {
//
//    }
//}
//
//
///**
// * 1. Player rolls dice and moves the to a position.
// * 2. If dice is 6 or there is a ladder, player is given another chance.
// * 3. In case player ends up on snake, it will fall to a lower position.
// * 4. If player reaches index 100, he is alloted the next available position.
// * 5. Game ends when n-1 player reaches to terminal index.
// */
//
//
//class GameManager {
//
//    private Board board;
//    private Dice dice;
//    private List<SNLPlayer> playerList;
//
//    public GameManager(Board board,
//                       Dice dice,
//                       List<SNLPlayer> playersList) {
//
//    }
//
//    public SNLResult startGame() {
//        Integer currentPlayerIndex = 0;
//        while(board.getActivePlayers() != 1) {
//            SNLPlayer player = playerList.get(currentPlayerIndex);
//            Integer roll = dice.roll();
//            PostMove postMove = board.makeMove(player, roll);
//            Integer currentPlayerIndex = getNextPlayerIndex(postMove);
//        }
//    }
//
//    private Integer getNextPlayerIndex(PostMove postMove) {
//
//    }
//}
//
//
//class SNLResult {
//    private Map<Player, Integer> result;
//
//    public SNLResult() {
//
//    }
//}
//
//class SNLPlayer {
//    public SNLPlayer(String name, SNLColor color) {
//
//    }
//}
//
//enum SNLColor {
//    RED, BLUE, GREEN;
//}
//
//class Board {
//    private Map<Player, Integer> playerPositionMap;
//
//    private List<Player> playerList;
//
//    public Board(Snake snakes,
//                 Ladder ladders,
//                 List<Player> playerList) {
//
//    }
//
//    public PostMove makeMove(SNLPlayer player, Integer count) {
//
//    }
//
//    public int getActivePlayers() {
//        return 0;
//    }
//}
//
//
//class PostMove {
//    private boolean isSamePlayerChance;
//    private boolean isGameOver;
//    private Map<Player, Integer> positionMap;
//    private
//}
//
//class Snake {
//    private Integer from;
//    private Integer to;
//}
//
//class Ladder {
//    private Integer from;
//    private Integer to;
//}
//
//class Dice {
//    public Integer roll() {
//        return 5;
//    }
//}