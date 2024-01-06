/**
 *
 * Given a string
 *  find a longest sub string with no duplicate characters
 *
 *  eg: abcdeabc --> abcde // 5
 *  eg: abcbdef --> bdef // 4
 *  eg: aaabaaa --> ab // 2
 *  eg: defabcdef --> defabc // 6
 *  eg: xyzabcdakl --> bcdakl // 6
 *
 *  x + maxDistinctSubStringlength("yzabcdakl")
 *  y + maxDistinctSubStringlength("zacbcdyaklmnop")
 */
public class WalmartSecond {

    static int max = 0;

    public static void main(String[] args) {

        String input = "abcdefabc";
        maxDistinctSubStringlength(input, 1, input.length(), input.charAt(0));
        System.out.println(max);
    }

    private static void maxDistinctSubStringlength(String inp, int startIndex, int endIndex, char c) {
        int len = 1;
        String subString = inp.substring(startIndex, endIndex);
        int eleIndex = subString.indexOf(c);
        subString = subString.substring(startIndex, eleIndex);
        len += maxDistinctSubStringlength(subString, );

    }

}
