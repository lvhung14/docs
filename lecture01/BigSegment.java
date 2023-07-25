package lecture01;

import java.util.ArrayList;
import java.util.Scanner;

public class BigSegment {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a, b;
		int left = sc.nextInt();
		int right = sc.nextInt();
		int index = 1;
		for(int i = 1; i < n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a <= left && b >= right) {
				left = a;
				right = b;
				index = i + 1;
			} else if(a < left || b > right) {
				index = -1;
			}
		}
		System.out.println(index);		
	}
}
