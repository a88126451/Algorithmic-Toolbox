import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    private static long getFibonacciSum(long n) {

        int[] f = new int[60];
        f[0] = 0;
        f[1] = 1;
       
        for(int i = 2 ; i < 60 ; i++)
        {
            f[i] = (f[i - 1] +f[i - 2]) % 10 ; 
    
        }

        long sum = 0;

        for(int i = 1; i <= (n % 60); i++)
        {
            sum += f[i];

        }
        return sum % 10;
 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

