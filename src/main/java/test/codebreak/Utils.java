package test.codebreak;

import java.util.Set;

public final class Utils {

    public static <T> void printSet(Set<T> s){
        s.stream().forEach(System.out::println);
    }
}
