package lecture02;

import java.util.ArrayList;
import java.util.Scanner;

public class Wrath {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		int last = 0;
		int count = 0;
		int j = n - 1, i = n - 1;
		for (i = n - 1; i > 0; i--) {
			j = Math.min(j, i);
			last = Math.max(0, i - a.get(i));
			if (j > last) {
				count += (j - last);
				j = last;
			}
		}
		System.out.println(n - count);
	}
}