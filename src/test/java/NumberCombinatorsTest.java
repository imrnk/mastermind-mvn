import org.junit.Test;
import test.codebreak.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertTrue;

public class NumberCombinatorsTest {

    @Test
    public void combination() {

        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0};
        IntStream.Builder ib = IntStream.builder();
        NumberCombinators.combination(0, 2, 2, arr, ib);
        //Utils.printSet(s);
       //ib.build().filter(i -> (i < 78986555 && i > 78986550)).forEach(System.out::println);


    }

    @Test
    public void caseNVP1(){
        Map<Integer, Integer> unchngDigitMap = new HashMap<>();
        Map<Integer, Integer> replacedDigitMap = new HashMap<>();


       unchngDigitMap.put(0, 1);
       unchngDigitMap.put(1, 2);
       replacedDigitMap.put(2, 1);
       replacedDigitMap.put(4, 3);
       replacedDigitMap.put(5, 5);

        //IntStream result = NumberCombinators.caseNVP(unchngDigitMap, replacedDigitMap, 8);
        //assertTrue(!result.filter(i -> i == 32000513).findAny().isPresent());
       // assertTrue(result.filter(i -> i == 120511).findAny().isPresent());
        /**
        Using a stream supplier helps when I need to reuse the stream for multiple operation
        */
        Supplier<IntStream> streamSupplier = () -> NumberCombinators.caseNVP(unchngDigitMap, replacedDigitMap, 8);

        //result.boxed().collect(Collectors.toList()).forEach(System.out::println);
        assertTrue(streamSupplier.get().filter(i -> i == 12000246).findAny().isPresent());
        System.out.println(streamSupplier.get().count());
        //assertTrue(result.filter(i -> i == 32000642).findAny().isPresent());
    }

    @Test
    public void caseNVP2(){
        Map<Integer, Integer> unchngDigitMap = new HashMap<>();
        Map<Integer, Integer> replacedDigitMap = new HashMap<>();


        unchngDigitMap.put(0, 1);
        unchngDigitMap.put(1, 2);
        unchngDigitMap.put(2, 3);
        //replacedDigitMap.put(1, 2);
        //replacedDigitMap.put(2, 3);

        //IntStream result = NumberCombinators.caseNVP(unchngDigitMap, replacedDigitMap, 8);
        //assertTrue(!result.filter(i -> i == 32000513).findAny().isPresent());
        // assertTrue(result.filter(i -> i == 120511).findAny().isPresent());
        /**
         Using a stream supplier helps when I need to reuse the stream for multiple operation
         */
        Supplier<IntStream> streamSupplier = () -> NumberCombinators.caseNVP(unchngDigitMap, replacedDigitMap, 3);

        streamSupplier.get().boxed().collect(Collectors.toList()).forEach(System.out::println);
       // assertTrue(streamSupplier.get().filter(i -> i == 12000246).findAny().isPresent());
        System.out.println(streamSupplier.get().count());
        //assertTrue(result.filter(i -> i == 32000642).findAny().isPresent());
    }

    @Test
    public  void testNV() {
        Map<Integer, Integer> replacedDigitMap = new HashMap<>();


        replacedDigitMap.put(0, 1);
        replacedDigitMap.put(1, 3);
        replacedDigitMap.put(2, 5);

        /**
         Using a stream supplier helps when I need to reuse the stream for multiple operation
         */
        Supplier<IntStream> streamSupplier = () -> NumberCombinators.caseNV(replacedDigitMap, 3);

        assertTrue(!streamSupplier.get().filter(i -> 100 == (i -i % 100)).findAny().isPresent());
        assertTrue(!streamSupplier.get().filter(i -> i == 230).findAny().isPresent());
        assertTrue(!streamSupplier.get().filter(i -> i == 345).findAny().isPresent());

    }

    @Test
    public void generateCombinations() {
    }
}