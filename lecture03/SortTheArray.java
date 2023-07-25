package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class SortTheArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] as = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			as[i] = a[i];
		}
		Arrays.sort(as);
		int l = 0, r = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] != as[i]) {
				l = i;
				break;
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] != as[i]) {
				r = i;
				break;
			}
		}
		int temp = 0;;
		for (int i = l, j = r; i < j; i++, j--) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		if (!Arrays.equals(a, as)) {
			System.out.println("no");
			return;
		}
		System.out.println("yes");
		System.out.println((l + 1) + " " + (r + 1));
	}
}
