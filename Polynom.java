package codehunger.polynom;

import java.util.ArrayList;

import static codehunger.polynom.NumberHelpers.print;

public class Polynom extends ArrayList<Integer> {
	private float[] possibleZeros, roots;
	// Creates the polynom and loads its solution
	public Polynom (int[] coeffs) {
		for(int coeff: coeffs)
			add(coeff);
		solve();
	}
	// Finds the possible roots and finds the real ones
	public void solve () {
		possibleZeros = possibleZeros();
		findRealRoots();
	}
	// Returns polynom's roots
	public float[] getRoots () {
		return roots;
	}
	// Calculates polynom's value for given X
	public float evaluateFor (float n) {
		float result = 0;
		print(n);
		float[] coeffs = toFloat();
		for (float c: coeffs) {
			if (result == 0) result = c;
			else result = result * n + c;
			print(result);
		}
		return result;
	}
	// Returns the main coefficient of the polynom
	public int first() {
		return get(0);
	}
	// Returns the free member of the polynom
	public int last() {
		return get(size() - 1);
	}
	// Calculates the possible zeros of the polynom 
	private float[] possibleZeros () {
		int[] mainCoeffDivisors = NumberHelpers.getDivisors(first()),
				freeMemberDivisors = NumberHelpers.getDivisors(last());
		float[] possibleZeros = new float[mainCoeffDivisors.length * freeMemberDivisors.length * 2];
		int i = 0;
		for(int p: freeMemberDivisors)
			if (p == 0)
				break;
			else for(int q: mainCoeffDivisors)
				if (q == 0)
					break;
				else
					possibleZeros[i++] = (float) p / q;
		roots = new float[i];
		return possibleZeros;
	}
	// Goes trough the possible roots and filters the real ones
	private void findRealRoots () {
		int i = 0;
		for(float root: possibleZeros) {
			if (root == 0)
				break;
			if (evaluateFor(root) == 0)
				roots[i++] = -root;
			if (evaluateFor(-root) == 0)
				roots[i++] = root;
		}
	}
	// Returns the polynom's coefficients in the form of a float array
	private float[] toFloat () {
		float[] array = new float[size()];
		for(int i = 0; i < size(); i++)
			array[i] = get(i);
		return array;
	}
}
