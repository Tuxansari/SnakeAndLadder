import java.util.List;

public class FirstSquare implements ISquare {

    private int spotId;
    List<Player> players;

    public FirstSquare(int spotId, List<Player> playerList){
        this.spotId = spotId;
        this.players = playerList;
    }

    @Override
    public int getPosition() {
        return spotId;
    }

    @Override
    public void enter(Player player) {
        players.add(player);
    }

    @Override
    public void leave(Player player) {
        players.remove(player);
    }

    @Override
    public boolean isFirstSquare() {
        return true;
    }

    @Override
    public boolean isLastSquare() {
        return false;
    }
}
