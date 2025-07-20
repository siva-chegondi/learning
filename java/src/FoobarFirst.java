/**
 * First problem
 * cut cake into equal pieces
 */
public class FoobarFirst {

    public static void main(String[] args) {
        System.out.println(solution("abcabcabc"));
    }

    private static int solution(String x) {
        //Your code here
        int cutSize = 1;
        int maxCuts = x.length();
        int totalMnMs = x.length();

        while(cutSize <= totalMnMs) {
            if (totalMnMs % cutSize == 0) {
                boolean isEqual = true;
                // Check if equal parts
                String part = x.substring(0, cutSize);
                for(int i = cutSize; i < totalMnMs; i = i + cutSize) {
                    if (!part.equals(x.substring(i, i + cutSize))) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    maxCuts = totalMnMs / cutSize;
                    break;
                }
            }
            ++cutSize;
        }
        return maxCuts;
    }
}
