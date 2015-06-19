package codehunger.polynom;

public class NumberHelpers {
	// Makes n positive and returns its positive divisors
	public static int[] getDivisors(int n) {
		n = n < 0 ? -n : n;
		int[] divisors = new int[n];
		int i = 0;
		for (int d=1; d*d<=n; d++)
			if(n % d == 0) {
				divisors[i++] = d;
				if (d*d < n)
					divisors[i++] = n / d;
			}
		return divisors;
	}
	// Prints the given value in an 8-column cell
	public static void print (float n) {
		int i = (int) n;
		System.out.format("%8s", n == i ? String.valueOf(i) : String.valueOf(n));
	}
}
