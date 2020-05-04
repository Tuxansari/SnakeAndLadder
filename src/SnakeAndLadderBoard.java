import java.util.*;

public class SnakeAndLadderBoard {

    List<Square> gameBoard = new ArrayList<>();
    HashMap<Integer, Integer> transformMapping = new HashMap<>();
    HashMap<Integer, Integer> playerPosition = new HashMap<>();
    int winningPlayerId;
    List<Player> playerList;
    int diceSize,totalDice;
    boolean isGameCompleted;
    int boardSize;

    public SnakeAndLadderBoard(List<Player> playerList, List<Transform> transformList, int boardSize, int diceSize, int totalDice) {
        // setup board
        Square firstSpot = new Square(0, playerList);
        gameBoard.add(firstSpot);
        for (int i=1;i<=boardSize;i++){
            gameBoard.add(new Square(i));
        }

        // fill transform
        for (Transform transform : transformList) {
            transformMapping.put(transform.getStartPoint(), transform.getEndPoint());
        }

        // setup players on start position
        for (Player player : playerList)
            playerPosition.put(player.id, 0);

        // set winning player id
        winningPlayerId = -1;

        this.playerList = playerList;
        this.diceSize = diceSize;
        this.totalDice = totalDice;
        this.boardSize = boardSize;
    }

    public boolean isGameCompleted() {
        return winningPlayerId != -1;
    }

    public int getWinner(){
        return winningPlayerId;
    }
}
