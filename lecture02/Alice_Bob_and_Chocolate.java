package lecture02;

import java.util.ArrayList;
import java.util.Scanner;

public class Alice_Bob_and_Chocolate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			a.add(sc.nextInt());
		}
		int count = 0;
		int l = 0, r = n - 1;
		int t1 = 0, t2 = 0;
		while(l <= r) {
			if(t1 + a.get(l) <= t2 + a.get(r)) {
				t1 += a.get(l);
				l++;
			} else {
				t2 += a.get(r);
				r--;
			}
		}
		System.out.println(l + " " + (n - l));
	}
}	
