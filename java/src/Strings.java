import java.util.HashMap;
import java.util.Map;

/**
 * abc == bac
 * string chars to map
 */

public class Strings {

    public static void main(String[] args) {

        String inp1 = "abc";
        String inp2 = "bac";

        // System.out.println(isSame(inp1, inp2));

        System.out.println(toMap(inp1));
    }

    static Map<Character, Integer> toMap(String a) {

        final Map<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.computeIfPresent(c, (x, va) -> ++va);
        }
        return map;
    }

    /*private static boolean isSame(String a, String b) {

        boolean isValid = true;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {

        }

        for(Character x: a.toCharArray()) {
            map.putIfAbsent(x, 0);
            Integer val = map.get(x);
            map.put(x, ++val);
        }

        System.out.println(map);

        for(Character y: b.toCharArray()) {

            // If no char in the map
            isValid = !map.containsKey(y);
            if(!isValid) {
                break;
            }

            Integer count = map.get(y);

            // if char count is already 0
            isValid = !(count == 0);
            if (!isValid) {
                break;
            }

            map.put(y, --count);
        }

        System.out.println(map);

        // if any balance value is there in map
        if (isValid) {
            isValid = map.values().stream().noneMatch(v -> v > 0);
        }

        return isValid;
    }*/
}
