import java.util.Scanner;

public class Fibonacci {
  // recursion
  private static long calc_fib_naive(int n) {
    if (n <= 1)
      return n;

    return calc_fib(n - 1) + calc_fib(n - 2);
  }
  // iterate
  private static long calc_fib(int n) {
    int ptp= 0;
    int p = 1;
    int sum = 0;
    
    if (n <= 1) return n;
    
    for(int i = 2; i <= n; i++) {
      sum = ptp + p;
      ptp = p;
      p = sum;
    }
    return sum;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
