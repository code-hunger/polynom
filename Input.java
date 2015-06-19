package codehunger.polynom;

import java.io.InputStream;
import java.util.Scanner;

public class Input {
	private Scanner scanner;
	
	public Input (InputStream stream) {
		scanner = new Scanner(stream);
	}
	
	public int[] readNumbers() {
		int count = scanner.nextInt();
		int[] numbers = new int[count];
		for (int i=0; i<count; i++)
			numbers[i] = scanner.nextInt();
		return numbers;
	}
	
	public int[] getTestNumbers () {		
		int[] numbers = { 1, 14, 47, -38, -240};
		return numbers;
	}
}
