public class Player {

    private ISquare square;

    protected int id;
    protected String name;

    public Player(int id) {
        this.id = id;
    }

//    public void move(int moves) {
//        square.leave(this);
//        square = square.moveAndLand(this, moves);
//        square.enter(this);
//    }

}
