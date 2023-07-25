package lecture02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Books {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}

		int count = 0;
		int r = 0, l = 0;
		int maxBook = 0;
		while ((r) < n && (l) < n) {
			if (count + arr.get(r) <= t) {
				count += arr.get(r);
				r++;
			} else {
				count -= arr.get(l);
				l++;
			}
			if (count <= t) {
				maxBook = Math.max(maxBook, r - l);
			}
		}
		System.out.println(maxBook);
	}
}
