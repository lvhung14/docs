package lecture02;

import java.util.ArrayList;
import java.util.Scanner;

public class GeorgeAndRound {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		for(int i = 0; i < m; i++) {
			b.add(sc.nextInt());
		}
		int count = 0;
		int j = 0;
		for(int i = 0; i < m; i++) {
			if(j < n) {
				if(b.get(i) >= a.get(j)) {
					count++;
					j++;
				}
			} else break;
		}
		System.out.println(n - count);
	}
}
