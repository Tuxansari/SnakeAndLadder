import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeAndLadderGame implements Game {

    SnakeAndLadderBoard board;
    DiceService diceService;
    HashMap<Integer, Integer> transformMapping = new HashMap<>();
    Queue<Player> players = new LinkedList<>();
    Player winningPlayer;

    public SnakeAndLadderGame(List<Player> playerList, List<Transform> transformList, int boardSize, int diceSize, int totalDice) {
        board = new SnakeAndLadderBoard(playerList, boardSize);
        diceService = new DiceService(diceSize, totalDice);
        // fill transform
        for (Transform transform : transformList) {
            transformMapping.put(transform.getStartPoint(), transform.getEndPoint());
        }
        ISquare firstSpot = board.findSquare(0);
        for (Player player : playerList) {
            player.setSquare(firstSpot);
            players.add(player);
        }
    }

    @Override
    public void start() {
        System.out.println("Game Started");
        System.out.println("Total Player : " + players.size());
        while(!isGameCompleted()) {
            Player player = players.remove();
            try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
            turn(player);
            ISquare square = player.getPosition();
            if (square.isLastSquare()){
                winningPlayer = player;
            }
            players.add(player);
        }
        System.out.println("Player " + getWinner().id + " wins");
    }

    @Override
    public void turn(Player player) {
        int diceValue = diceService.roll();
        ISquare currentPos = player.getPosition();
        currentPos.leave(player);

        int updatedPos = currentPos.getPosition() + diceValue;
        if (updatedPos == board.getBoardSize()) {
            winningPlayer = player;
        } else if (updatedPos < board.getBoardSize()) {
            if (transformMapping.containsKey(updatedPos))
                updatedPos = transformMapping.get(updatedPos);
        } else {
            updatedPos = currentPos.getPosition();
        }

        System.out.println("Player " + player.id + " rolled a dice value " + diceValue + " and moves from " + currentPos.getPosition() + " to " + updatedPos);
        ISquare nextPos = board.findSquare(updatedPos);
        nextPos.enter(player);
        player.setSquare(nextPos);
    }

    @Override
    public void undoMove() {
    }

    @Override
    public void resetBoard() {
    }

    @Override
    public boolean isGameCompleted() {
        return winningPlayer != null;
    }

    @Override
    public Player getWinner(){
        return winningPlayer;
    }
}
