public interface Game {

    void start();
    void turn(Player player);
    boolean isGameCompleted();
    Player getWinner();
    void undoMove();
    void resetBoard();

}
