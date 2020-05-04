public interface GameService {

    void start();
    void turn(Player player);
    void undoMove();
    void resetBoard();

}
