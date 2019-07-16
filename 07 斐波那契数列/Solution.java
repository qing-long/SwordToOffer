public class Solution{
	public int Fibonacci(int n) {
		if (n < 0 || n > 39) {
			return -1;
		}
		if (n <= 1) {
			return n;
		}
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.Fibonacci(0));
	}
}