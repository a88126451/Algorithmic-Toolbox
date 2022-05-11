import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current * current;
        }

        return sum % 10;
    }
    // f0^2 + f1^2 + f2^2+......+fn^2 
    // = f0^2 + ( f1f2– f0f1)+(f2f3 – f1f2 ) +......+ (fnfn+1 – fn-1fn ) 
    // = fnfn+1 (Since f0 = 0) 
    private static long getFibonacciSumSquares(long n) {
    	long[] f = new long[60];
        f[0] = 0;
        f[1] = 1;
       
        for(int i = 2 ; i < 60 ; i++)
        {
            f[i] = (f[i - 1] +f[i - 2]) % 10 ; 
    
        }
        
        long sum = 0;
        sum = f[(int) (n % 60)] * f[(int) ((n + 1) % 60)];
        return sum % 10;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}

