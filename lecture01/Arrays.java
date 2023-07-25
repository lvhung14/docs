package lecture01;

import java.util.ArrayList;
import java.util.Scanner;

public class Arrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int na = sc.nextInt();
		int nb = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		for(int i = 0; i < na; i++) {
			A.add(sc.nextInt());
		}
		for(int i = 0; i < nb; i++) {
			B.add(sc.nextInt());
		}
		
		System.out.println(A.get(k - 1) < B.get(nb - m) ? "YES": "NO");
	}
}
