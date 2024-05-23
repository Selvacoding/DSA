import java.util.*;

public class SnakeAndLadder {
    private static final int WINNING_POSITION = 100;
    private static final int[] SNAKE_POSITIONS = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] LADDER_START_POSITIONS = {1, 4, 9, 21, 28, 36, 51, 71, 80};

    private static final Map<Integer, Integer> LADDER_MAP = new HashMap<>();
    private static final Map<Integer, Integer> SNAKE_MAP = new HashMap<>();

    static {
        for (int i = 0; i < LADDER_START_POSITIONS.length; i++) {
            LADDER_MAP.put(LADDER_START_POSITIONS[i], LADDER_START_POSITIONS[i] + i + 1);
        }

        for (int i = 0; i < SNAKE_POSITIONS.length; i++) {
            SNAKE_MAP.put(SNAKE_POSITIONS[i], SNAKE_POSITIONS[i] - i - 1);
        }
    }

    private int currentPlayerPosition;
    private final Random random;

    public SnakeAndLadder() {
        this.currentPlayerPosition = 0;
        this.random = new Random();
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    private int getNextPosition(int currentPosition, int diceValue) {
        int nextPosition = currentPosition + diceValue;
        if (nextPosition > WINNING_POSITION) {
            return currentPosition;
        }

        if (LADDER_MAP.containsKey(nextPosition)) {
            return LADDER_MAP.get(nextPosition);
        } else if (SNAKE_MAP.containsKey(nextPosition)) {
            return SNAKE_MAP.get(nextPosition);
        }

        return nextPosition;
    }

    public void playGame() {
        while (currentPlayerPosition < WINNING_POSITION) {
            int diceValue = rollDice();
            currentPlayerPosition = getNextPosition(currentPlayerPosition, diceValue);
            System.out.println("Player moved to position: " + currentPlayerPosition);

            if (currentPlayerPosition == WINNING_POSITION) {
                System.out.println("Congratulations! Player wins!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        SnakeAndLadder game = new SnakeAndLadder();
        game.playGame();
    }
}
