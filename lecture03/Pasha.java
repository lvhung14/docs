package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class Pasha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] cups = new int [2*n];
		for(int i = 0 ; i < 2*n; i++) {
			cups[i] = sc.nextInt();
		}
		Arrays.sort(cups);
		double m = Math.min(1.0 * cups[0], cups[n]* 0.5);
		double water = Math.min(w, 3 * m * n);
		System.out.println(water);
	}
}
