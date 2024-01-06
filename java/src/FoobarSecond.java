import java.util.Arrays;

/**
 * Sort versions
 */
public class FoobarSecond {

    public static void main(String []args) {

        String[] l = new String[]{"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
        System.out.println(String.join(",",sortedList(l)));
    }

    private static String[] sortedList(String[] l) {

        Arrays.sort(l, (a, b) -> {
            int[] x = Arrays.stream(a.split("\\.")).mapToInt(Integer::parseInt).toArray();
            int[] y = Arrays.stream(b.split("\\.")).mapToInt(Integer::parseInt).toArray();

            int compare = 0;

            int len = Math.min(x.length, y.length);
            for(int i = 0; i < len; i++) {
                compare = compare + x[i] == y[i] ? 0 : x[i] - y[i];
                if (compare != 0) break;
            }

            if (compare == 0 && x.length != y.length) {
                compare = x.length - y.length;
            }

            return compare;
        });

        return l;
    }
}
