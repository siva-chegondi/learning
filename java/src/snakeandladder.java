import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Snake Ladder
 *
 * Read board to load in map
 * play using that map
 */
public class snakeandladder {

    static int snakes = 0, ladders = 0, end = 0;
    static Map<Integer, String> board = new HashMap<>();
    static InputStreamReader ins = new InputStreamReader(System.in);
    static BufferedReader reader = new BufferedReader(ins);

    public static void main(String args[]) {
        readBoard();
        if(playGame()) {
            System.out.println("Possible " +snakes + " " + ladders);
        } else {
            System.out.println("Not possible "+ snakes + " " + ladders + " " + end);
        }
    }

    private static void readBoard() {
        int i = 0, count = 100;
        try {
            while (i < 10) {
                String s = reader.readLine();
                String[] inps = s.split(" ");
                int len = inps.length;
                if (i % 2 == 0) {
                    // read left to right
                    for (int j = 0; j < len; j++) {
                        board.put(count--, inps[j]);
                    }
                } else {
                    // read right to left
                    for(int j = len-1; j > -1; j--) {
                        board.put(count--, inps[j]);
                    }
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean playGame() {
        String next;
        boolean reached = false;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext() && !reached) {
            int dice = sc.nextInt();
            next = finalPoint(dice);
            reached = next.equalsIgnoreCase("End");
            if (!reached) {
                end = Integer.parseInt(next);
            }
        }
        return reached;
    }

    private static String finalPoint(int dice) {
        String next = board.get(end + dice);
        if ((!next.contains("L") && !next.contains("S")) || next.equalsIgnoreCase("End")) {
            return next;
        }
        if (next.contains("S(")) { snakes++; }
        else if(next.contains("L")) { ladders++; }
        int nextPoint = (next.equalsIgnoreCase("Start")) ? 1:
                Integer.parseInt(next.replaceAll("([\\(\\)a-zA-Z])",""));
        return board.get(nextPoint);
    }
}