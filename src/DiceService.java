import java.util.Random;

/**
 * Req-1: dice can have more than 6 faces
 * Req-2: multiple dices support
 * Req-3: If 6 comes, player will another chance to roll
 */
public class DiceService {
    int maxBound;
    int totalDice;
    Random random;

    public DiceService(int maxBound, int totalDice) {
        random = new Random();
        this.maxBound = maxBound;
        this.totalDice = totalDice;
    }

    public int roll() {
        int sum=0;
        for (int i=0;i<totalDice;i++) {
            int diceValue = random.nextInt(maxBound) + 1;
            if (diceValue == 6) {
                int count=0;
                while (diceValue == 6) {
                    count++;
                    diceValue = random.nextInt(maxBound) + 1;
                    if (count == 3) {
                        diceValue = 0;
                        count=0;
                        break;
                    }
                }
                diceValue += count*6;
            }
            sum += diceValue;
        }
        return sum;
    }
}
