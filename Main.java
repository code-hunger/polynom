package codehunger.polynom;

public class Main {

	public static void main(String[] args) {
		Input input = new Input(System.in);
		int[] coeffs = input.readNumbers();

		Polynom polynom = new Polynom(coeffs);
		
		System.out.print("Roots: ");
		for (float r: polynom.getRoots()) {
			if (r == 0)
				break;
			System.out.print(r + " ");
		}
		System.out.println();
	}
}
