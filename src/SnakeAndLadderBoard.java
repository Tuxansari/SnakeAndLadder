import java.util.*;

public class SnakeAndLadderBoard {

    private List<ISquare> gameBoard = new ArrayList<>();
    private int boardSize;

    public SnakeAndLadderBoard(List<Player> playerList, int boardSize) {
        // setup board
        ISquare firstSpot = new FirstSquare(0, playerList);
        gameBoard.add(firstSpot);
        for (int i=1;i<boardSize;i++){
            gameBoard.add(new Square(i));
        }
        ISquare lastSpot = new LastSquare(boardSize);
        gameBoard.add(lastSpot);
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public ISquare findSquare(int id) {
        return gameBoard.get(id);
    }
}
