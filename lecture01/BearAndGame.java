package lecture01;

import java.util.ArrayList;
import java.util.Scanner;

public class BearAndGame {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int pointer = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		for(int i = 0; i < n; i++) {
			if((pointer + 15) < arr.get(i)) {
				System.out.println(pointer + 15);
				return;
			}
			pointer = arr.get(i);
		}
		System.out.println(Math.min(pointer + 15, 90));
	}
}
