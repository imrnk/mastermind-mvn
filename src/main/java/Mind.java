import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Random;

public class Mind {

    private final int[] code = new int[4];
    private int guessCount = 0;
    private static final int MAX_GUESS = 10;

    public Mind() {
        prepareCode();
    }

    private void prepareCode() {
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            code[i] = random.nextInt(9);
            System.out.print(code[i]);
        }
        System.out.println("\n");
    }

    public int[] compareAndHint(int[] guess) {
        int[] hints = new int[code.length];
        if (guessCount < MAX_GUESS) {
            prepareHint(guess, hints);


        } else {
            //System.out.println("Your 10 guesses are over. Sorry");
            throw new RuntimeException("Your 10 guesses are over. Sorry");
        }
        guessCount++;
        return hints;
    }

    private void prepareHint(int[] guess, int[] hints) {
        if (guess.length != code.length)
            throw new IllegalArgumentException("code is of " + code.length
                    + " your guess is of " + guess.length);

        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (code[j] == guess[i] && i == j) {
                    hints[j] = 2;
                } else if (code[j] == guess[i]) {
                    hints[j] = 1;
                }
            }
        }

        Arrays.sort(hints);
    }

}
