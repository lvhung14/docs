package lecture02;

import java.util.Scanner;

public class Array {
	static final int MAX = (int)1e5 + 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int unique = 0;
		int l = 0;
		int r = 0;
		int[] abc = new int[MAX];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (l = 0; l < n; l++) {
			if (abc[arr[l]] == 0) {

				unique++;
			}
			abc[arr[l]]++;
			while (unique == k) {
				abc[arr[r]]--;
				if (abc[arr[r]] == 0) {
					System.out.println((r + 1) + " " + (l + 1));
					return;
				}
				r++;
			}
		}
		System.out.println("-1 -1");
	}

}
