import org.junit.Test;

import static org.junit.Assert.*;

public class MindTest {


    @Test
    public void compareAndHint() {
        int[] guess = new int[]{3,6,4,7};
        Mind m = new Mind();
        int[] hint = m.compareAndHint(guess);
        print(hint);
    }

    public void print(int[] ar) {
        for(int i : ar) {
            System.out.print(i + " ");
        }
    }
}