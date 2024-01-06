import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String... args) {
        System.out.println(solution("java spring boot java sivac"));
    }

    private static char solution(String input) {

        char[] arr = input.toCharArray();
        final Map<Character, Integer> map = new HashMap<>();

        for(char c: arr) {
            Character ch = c;
            if (map.containsKey(ch)) {
                Integer count = map.get(ch);
                map.put(ch, ++count);
            } else {
                map.put(ch, 1);
            }
        }

        AtomicInteger minIndex = new AtomicInteger(input.length());
        map.keySet().stream().filter(k -> map.get(k) == 1).forEach(k ->
                minIndex.set(Math.min(minIndex.get(), input.indexOf(k))));

        return input.charAt(minIndex.get());
    }
}