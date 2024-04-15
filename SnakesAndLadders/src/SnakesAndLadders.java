import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class SnakesAndLadders {
    public static void main(String[] args) {

    }
}


/**
 * 1. Player rolls dice and moves the to a position.
 * 2. If dice is 6 or there is a ladder, player is given another chance.
 * 3. In case player ends up on snake, it will fall to a lower position.
 * 4. If player reaches index 100, he is alloted the next available position.
 * 5. Game ends when n-1 player reaches to terminal index.
 */


class SnakesAndLaddersManager {

    private Board board;
    private Dice dice;

    // Using Deque to roll players chance by chance.
    private Deque<SNLPlayer> playingQueue = new ArrayDeque<>();
    private Deque<SNLPlayer> winners = new ArrayDeque<>();

    public SnakesAndLaddersManager(Board board,
                       Dice dice,
                       List<SNLPlayer> playersList) {

    }

    public SNLResult startGame() {
        Integer currentPlayerIndex = 0;
        while(playingQueue.size() > 1) {
            SNLPlayer player = playingQueue.peekFirst();
            playingQueue.pollFirst();
            Integer roll = dice.roll();
            PostMove postMove = board.makeMove(player, roll);
            if (postMove.isSamePlayerChance) {
                playingQueue.addFirst(player);
            } else if (postMove.isWinner) {
                winners.addLast(player);
            } else {
                playingQueue.addLast(player);
            }
        }
        return null;
    }
}


class SNLResult {
    private Map<Player, Integer> result;

    public SNLResult() {

    }
}

class SNLPlayer {
    public SNLPlayer(String name, SNLColor color) {

    }
}

enum SNLColor {
    RED, BLUE, GREEN;
}

class Board {

    private Map<Player, Integer> playerPositionMap;

    private List<Player> playerList;

    private Map<Integer, Snake> snakeMap;

    private Map<Integer, Ladder> ladderMap;
    public Board(Snake snakes,
                 Ladder ladders,
                 List<Player> playerList) {

    }

    public PostMove makeMove(SNLPlayer player, Integer count) {
        // check if there is a snake or ladder
        // check if player moves to the end-position i.e. 100.
        return null;
    }

    // This utility will help to render board on ui.
    public Map<Player, Integer> getPlayerPositionMap() {
        return null;
    }
}


class PostMove {
    public boolean isSamePlayerChance;
    public boolean isWinner;
}

class Snake {
    private Integer from;
    private Integer to;
}

class Ladder {
    private Integer from;
    private Integer to;
}

class Dice {
    public Integer roll() {
        return 5;
    }
}