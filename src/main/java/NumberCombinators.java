import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NumberCombinators {

    public static void main(String[] args) {
      // generate(3,2);
        generateCombinations(4);
    }


    /*public static void generate(int n, int r) {
        Iterator<int[]> iterator = CombinatoricsUtils.combinationsIterator(n, r);
        while (iterator.hasNext()) {
            final int[] combination = iterator.next();
            System.out.println(Arrays.toString(combination));
        }
    }*/

    public static Set<int[]> generateCombinations(int length) {
        Set<int[]> allCombi = new HashSet<>();
        int[] n = new int[length];
        makeAtt(0, 10, length, n);
        allCombi.add(n);
        return allCombi;
    }

    private static void makeAtt(int min, int max, int depth, int[] vals) {
        //Guard against bad depth
        if (depth <= 0) return;
       /* if (depth == 0) {
            System.out.print("{");
            for (int d : vals) {
                System.out.print(d + " ");
            }
            System.out.print("}\n\n");
        }*/ else {
            for (int i = min; i < max; i = i + 1) {
                int[] newVals = new int[vals.length + 1];
                for (int z = 0; z < vals.length; z++)
                    newVals[z] = vals[z];
                newVals[vals.length] = i;
                makeAtt(min, max, depth - 1, newVals);
            }
        }
    }

    private static int maxNumber(int length) {
        int[] dig = new int[length];

        for (int i = 0; i < dig.length; i++) {
            dig[i] = 9;
        }


        int maxnum = 0;
        for (int i = 1; i < dig.length; i++) {
            maxnum += Math.pow(10, dig.length - i) * dig[i];
        }
        return maxnum + 9;
    }

    public void garbage() {
        int n = 46132;

        int nlength = (int) Math.floor(Math.log10(n));


        int t = (int) n / (10 ^ nlength);
        int h = (int) (n - t ^ nlength) / 100;
        int d = (int) (n - t * 1000 - h * 100) / 10;
        int r = (int) (n - t * 1000 - h * 100 - d * 10);


        System.out.println(t);
        System.out.println(h);
        System.out.println(d);
        System.out.println(r);


        //double place = (int)Math.pow(10, tenthPower);

        // System.out.println(tenthPower);
    }


}
