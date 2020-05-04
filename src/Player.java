public class Player {

    private ISquare square;

    protected int id;
    protected String name;

    public Player(int id) {
        this.id = id;
    }

    public void setSquare(ISquare square) {
        this.square = square;
    }

    public ISquare getPosition() {
        return square;
    }

}
