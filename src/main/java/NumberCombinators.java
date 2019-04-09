import org.apache.commons.math3.util.CombinatoricsUtils;

import java.util.*;

public class NumberCombinators {

    public static void main(String[] args) {
        Set<int[]> allCombi = generateCombinations(4);
        System.out.println(allCombi.size());
    }

    private void remove(int place, int digit, Set<int[]> allCombi) {
        for(Iterator<int[]> iter =  allCombi.iterator(); iter.hasNext();) {
            int[] eachArr = iter.next();
            if(placeAndDigitMatch(place,digit,eachArr)) {
                iter.remove();
            }
        }
    }

    private boolean placeAndDigitMatch(int place, int digit, int[] iarr) {
        for(int i =0; i <iarr.length; i++) {
            if(i ==place && iarr[i] == digit)
                return true;
        }
        return false;
    }

    public static void print(Set<int[]> s) {
        for(int[] a : s) {
            for(int j : a) {
                System.out.print(j + " ");
            }
            System.out.println(" ");
        }
    }

    public static Set<int[]> generateCombinations(int length) {
        Set<int[]> allCombi = new HashSet<>();
        int[] n = new int[length];
        makeAtt(0, 10, length, n, allCombi);
        //allCombi.add(n);
        return allCombi;
    }

    private static void makeAtt(int min, int max, int depth, int[] vals, Set<int[]> allCombi) {
        //Guard against bad depth
        if (depth < 0) return;
        if (depth == 0) {
            int half = vals.length /2;
            int[] finalArr = new int[half];

            for(int j = half -1 , k =0; j < vals.length - 1; j++, k++) {
                finalArr[k] = vals[j+1];
            }

            allCombi.add(finalArr);

        } else {
            for (int i = min; i < max; i = i + 1) {
                int[] newVals = new int[vals.length + 1];
                for (int z = 0; z < vals.length; z++)
                    newVals[z] = vals[z];
                newVals[vals.length] = i;

                makeAtt(min, max, depth - 1, newVals, allCombi);
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
    }


}
