import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    
     private static long getFibonacciSum(long n) {
        int[] f = new int[60];
        f[0] = 0;
        f[1] = 1;
       
        for(int i = 2 ; i < 60 ; i++) {
            f[i] = (f[i - 1] +f[i - 2]) % 10 ; 
    
        }

        long sum = 0;

        for(int i = 1; i <= (n % 60); i++) {
            sum += f[i];

        }
        return sum % 10;
 
    }
    
    private static long getFibonacciPartialSum(long from, long to) {
        return (10 + getFibonacciSum(to) - getFibonacciSum(from - 1)) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}

