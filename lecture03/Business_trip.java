package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class Business_trip {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] month = new int[12];
		for (int i = 0; i < 12; i++) {
			month[i] = sc.nextInt();
		}
	//	System.out.println(Arrays.toString(month));
		Arrays.sort(month);
		int count = month[11];
		int i = 10;
		int count1 = 1;
		while(i >= 0) {
			if(k == 0) {
				System.out.println("0");
				return;
			}
			if(count < k) {
				count += month[i--];
				count1++;
			} else break;
		}
		if(count < k) {
			System.out.println("-1");
		}
		else System.out.println(count1);
	}
}
