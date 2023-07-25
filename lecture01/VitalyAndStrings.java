package lecture01;

import java.util.Arrays;
import java.util.Scanner;

public class VitalyAndStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char[] t = sc.nextLine().toCharArray();
		for(int i = s.length - 1; i >= 0; i--) {
			if(s[i] == 'z') {
				s[i] = 'a';
			}
			else {
				s[i]++;
				break;
			}
		}
		System.out.println(Arrays.equals(s, t) ? "No such string".toCharArray() : s);
	}
}
