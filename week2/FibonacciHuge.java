import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }
    // find the Pisano Period
    private static long getPisano(long m) {
    	long prev = 0;
        long curr = 1;
        long res = 0;
         
        for(int i = 0; i < m * m; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
             
            if (prev == 0 && curr == 1)
                res= i + 1;
        }
        return res;
    }
    private static long getFibonacciHuge(long n, long m) {
    	long pisanoPeriod = getPisano(m);
        
        n = n % pisanoPeriod;
         
        long prev = 0;
        long curr = 1;
         
        if (n <= 1)
            return n;
              
        for(int i = 0; i < n - 1; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
        }
        return curr % m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

