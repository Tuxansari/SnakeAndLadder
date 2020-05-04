import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderService implements GameService {

    SnakeAndLadderBoard board;
    DiceService diceService;

    public SnakeAndLadderService(SnakeAndLadderBoard snakeAndLadderBoard) {
        this.board = snakeAndLadderBoard;
        diceService = new DiceService(snakeAndLadderBoard.diceSize, snakeAndLadderBoard.totalDice);
    }

    @Override
    public void start() {
        Queue<Player> turnQueue = new LinkedList<>();
        turnQueue.addAll(board.playerList);
        System.out.println("Game Started");
        System.out.println("Total Player : " + board.playerList.size());
        while(!board.isGameCompleted()) {
            Player player = turnQueue.remove();
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            turn(player);
            turnQueue.add(player);
        }
        System.out.println("Player " + board.getWinner() + " wins");
    }

    @Override
    public void turn(Player player) {
        int currPos = board.playerPosition.get(player.id);
        int diceValue = diceService.roll();
        int updatedPos = currPos + diceValue;
        if (updatedPos == board.boardSize) {
            board.winningPlayerId = player.id;
            board.isGameCompleted = true;
        } else if (updatedPos < board.boardSize) {
            if (board.transformMapping.containsKey(updatedPos))
                updatedPos = board.transformMapping.get(updatedPos);
        } else {
            updatedPos = currPos;
        }
        System.out.println("Player " + player.id + " rolled a dice value " + diceValue + " and moves from " + currPos + " to " + updatedPos);
        Square currSpot = board.gameBoard.get(currPos);
        currSpot.getPlayerList().remove(player);
        Square nextSpot = board.gameBoard.get(updatedPos);
        nextSpot.getPlayerList().add(player);
        board.playerPosition.put(player.id, updatedPos);
    }

    @Override
    public void undoMove() {
    }

    @Override
    public void resetBoard() {
    }
}
