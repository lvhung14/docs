package lecture02;

import java.util.ArrayList;
import java.util.Scanner;

public class Approximating_a_Constant_Range {
	static final int MAX = (int) 1e5 + 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		int diff = 0;
		int count = 0;;
		int j = 0;
		int[] arr = new int[MAX];
		for (int i = 0; i < n; i++) {
			if (arr[a.get(i)] == 0) {
				diff++;
			}
			arr[a.get(i)]++;
			while (diff > 2) {
				if (arr[a.get(j)] == 1) {
					diff--;
				}
				arr[a.get(j)]--;
				j++;
			}
			count = Math.max(count, i - j + 1);
		}
		System.out.println(count);

	}
}
