package lecture03;

import java.util.Scanner;

public class GukiZ_and_Contest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int position = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i] < a[j]) {
					position++;
				}
			}
			System.out.print(position + " ");
			position = 1;
		}
	}
}
