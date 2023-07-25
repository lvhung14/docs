package lecture06;

import java.util.*;

public class Test2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t-- > 0) {
			int n = scan.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = scan.nextInt();
			Arrays.sort(a);
			if (a.length <= 1)
				System.out.println(0);
			else {
				int sum = 0;
				for (int i = 0, j = a.length - 1; i < j; i++, j--)
					sum += a[j] - a[i];
				System.out.println(sum);
			}
		}
	}
}
