import java.util.*;

public class Player {

    private int guessCount = 0;
    int[] firstGuess = new int[4];
    int[] zeroToNine = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    Map<Integer, int[]> prevGuesses = new HashMap<>();
    private static Set<int[]> allCombi = new HashSet<>();

    public Player(int numLength) {
        allCombi = NumberCombinators.generateCombinations(numLength);
    }

    public int[] improveGuess(int[] hints) {
        int[] newGuess;
        if (guessCount == 0) {
            newGuess = firstGuess();
            prevGuesses.put(guessCount++, newGuess);
            return newGuess;
        } else {

            int[] hintCounts = countsInHints(hints);
            if (hintCounts[0] == 4) {        // All miss
                // Choose a new set of number
                newGuess = createNewSets(prevGuesses.get(guessCount));
                prevGuesses.put(guessCount++, newGuess);
                return newGuess;
            } else if (hintCounts[0] < 4) {   // Some matching in number and some matching in also position

            }
        }
        return null; //FIXME
    }

    private int[] firstGuess() {
        return new int[]{1, 1, 2, 2};
    }

    /**
     * Create a new set of numbers excluding all the numbers from previous guess
     * @param prevGuess
     * @return
     */
    private int[] createNewSets(final int[] prevGuess) {
        int[] newGuess = new int[4];

        ArrayList<Integer> prevs = new ArrayList<Integer>() {
            {
                for (int i : prevGuess) add(i);
            }
        };
        ArrayList<Integer> tillNines = new ArrayList<Integer>() {
            {
                for (int i : zeroToNine) add(i);
            }
        };

        tillNines.removeAll(prevs);
        for (int i = 0; i < 4; i++) {
            newGuess[i] = tillNines.get(i);
        }

        return newGuess;
    }


    /**
     * @param hints
     * @return an int array where - first element tells the count of 0
     * second element tells the count of 1
     * third element tells the count of 2
     */
    private int[] countsInHints(int[] hints) {
        int[] counts = new int[3];
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < hints.length; i++) {
            if (hints[i] == 0)
                zeros++;
            else if (hints[i] == 1)
                ones++;
            else if (hints[i] == 2)
                twos++;
        }
        counts[2] = twos;
        counts[1] = ones;
        counts[0] = zeros;
        return counts;
    }

}
