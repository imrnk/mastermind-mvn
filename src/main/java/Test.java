import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Test {

    Supplier<IntStream> streamSupplier;

    public static void main(String[] args) {

        Test t = new Test();
        t.test();
        int z = 0;
        while(true){
            if(z == 30) break;
            int i = t.offer();
            System.out.println(i);
            z++;
        }
    }

    public void test(){
        Map<Integer, Integer> replacedDigitMap = new HashMap<>();
        replacedDigitMap.put(0, 1);
        replacedDigitMap.put(1, 3);
        replacedDigitMap.put(2, 5);

        /**
         Using a stream supplier helps when I need to reuse the stream for multiple operation
         */
        streamSupplier = () -> NumberCombinators.caseNV(replacedDigitMap, 3);
    }

    public int offer(){
        return streamSupplier.get().findAny().orElseThrow(() -> new RuntimeException("Stream exhausted"));

    }

    public void removeFromStream(){
        streamSupplier.get().skip(1);
    }
}
