import java.util.*;
import java.lang.*;

public class primemailreads {

    static Map<Integer, Integer> primeMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfUnReadMails = sc.nextInt();
        loadPrimesIndex(noOfUnReadMails);
        System.out.print(readMails(noOfUnReadMails));
    }

    // method to check is prime
    private static boolean isPrime(int n) {
        boolean isPrime = true;
        for(int i = 3; i < n; i = i+2) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * method to load prime numbers map
     */
    private static void loadPrimesIndex(int n) {
        int noOfPrimes = 1;
        for(int i = 1; i <= n; i= i + 2) {
            if (isPrime(i)) {
                primeMap.put(i, noOfPrimes++);
            }
        }
    }

    private static int noOfPrimes(int n) {
        int noOfPrimes = 0;
        for(Integer i: primeMap.keySet()) {
            if (n >= i) {
                noOfPrimes = primeMap.get(i);
            }
            else {
                break;
            }
        }
        return noOfPrimes;
    }

    /**
     * lets read mails
     */
    private static int readMails(int n) {
        int noOfLoops = 0;
        while(n > 1) {
            int x = noOfPrimes(n);
            n = n - x;
            noOfLoops++;
        }
        if (n == 1) {
            noOfLoops++;
        }
        return noOfLoops;
    }
}
