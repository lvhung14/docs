package lecture03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Pasha_and_Tea {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		ArrayList<Integer> cup = new ArrayList<>();
		for (int i = 0; i < 2 * n; i++) {
			cup.add(sc.nextInt());
		}
		Collections.sort(cup);
		Double m = Math.min(1.0 * cup.get(0), 1.0 * cup.get(n) / 2);
		Double min = Math.min(w, 3 * m * n);
		System.out.println(min);
	}
}
