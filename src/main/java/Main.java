public class Main {

    public static void main(String[] args) {

        Mind m = new Mind();
        int[] guess = {1,1,2,2};

        int[] hints;
        try {
            while(true) {
                hints = m.compareAndHint(guess);
                printHint(hints);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.exit(0);
        }

    }

    protected static void printHint(int[] hint) {
        for(int i = 0; i < hint.length; i++) {
            System.out.print(hint[i] + " ");
        }
        System.out.println("\n");
    }
}
