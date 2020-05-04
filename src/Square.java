
public class Square implements ISquare {

    private int spotId;
    private Player player;

    public Square(int spotId) {
        this.spotId = spotId;
    }

    @Override
    public int getPosition() {
        return spotId;
    }

    @Override
    public void enter(Player player) {
        this.player = player;
    }

    @Override
    public void leave(Player player) {
        this.player = null;
    }

    @Override
    public boolean isFirstSquare() {
        return false;
    }

    @Override
    public boolean isLastSquare() {
        return false;
    }
}
