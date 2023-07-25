package lecture02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dressem_in_Vests {
	static class Vest {
		int u, v;

		public Vest(int u, int v) {
			this.u = u;
			this.v = v;
		}
		@Override
		public String toString() {
			return "" + this.u + " " + this.v;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		for(int i = 0; i < m; i++) {
			b.add(sc.nextInt());
		}
//		System.out.println("" + m + n + x + y);
//		System.out.println(a);
//		System.out.println(b);
		int count = 0;
		int l = 0, r = 0;
		int l1 = x;
		int r1 = y;
		ArrayList<Vest> result = new ArrayList<Vest>();
		for(r = 0, l = 0; r < n && l < m;) {
			if(a.get(r) - x > b.get(l)) {
				l++;
			} else if(a.get(r) + y < b.get(l)) {
				r++;
			} 
			else {
				result.add(new Vest(r++ + 1, l++ + 1));
			}
		}
		System.out.println(result.size());
		for(Vest v : result) {
			System.out.println(v);
		}
	}
}
