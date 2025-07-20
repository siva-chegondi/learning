/**
 * 7
 * 4 8
 * 2 5 9
 * 1 3 6 10
 */
public class FoobarThird {

    public static void main(String []args) {
        System.out.println(solution(3, 2));
    }

    private static String solution(long x, long y) {

        // pattern: (1 + y(y-1)/2) + (x-1)(y+1) + (x-1)(x-2)/2)
        long result = 1 + Double.valueOf((Math.pow(y, 2) - y) / 2).longValue();
        long res = (x-1) * (y + 1) + Double.valueOf((Math.pow(x, 2) - (3*x) + 2) / 2).longValue();
        return Long.toString(res + result);
    }
}
