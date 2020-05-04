import java.util.ArrayList;
import java.util.List;

public class Square {

    private int spotId;
    private List<Player> playerList = new ArrayList<>();

    public Square(int spotId) {
        this.spotId = spotId;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public Square(int id, List<Player> playerList) {
        this.spotId = id;
        this.playerList = playerList;
    }
}
