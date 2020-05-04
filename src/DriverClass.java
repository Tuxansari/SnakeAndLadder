import java.util.ArrayList;
import java.util.List;

public class DriverClass {

    public static void main(String[] strings) {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1));
        playerList.add(new Player(2));
        playerList.add(new Player(3));

        List<Transform> transformList = new ArrayList<>();
        transformList.add(new Transform(TransformType.SNAKE, 70, 65));
        transformList.add(new Transform(TransformType.SNAKE, 80, 75));
        transformList.add(new Transform(TransformType.SNAKE, 90, 85));
        transformList.add(new Transform(TransformType.LADDER, 20, 45));
        transformList.add(new Transform(TransformType.LADDER, 30, 55));
        transformList.add(new Transform(TransformType.LADDER, 40, 65));

        Game snakeAndLadderService = new SnakeAndLadderGame(playerList, transformList, 100, 6, 1);
        snakeAndLadderService.start();
    }
}
