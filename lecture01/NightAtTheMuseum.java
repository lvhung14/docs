package lecture01;

import java.util.Scanner;

public class NightAtTheMuseum {
	public static int minWay(char x, char y) {
		int a = Math.abs(x - y + 26);
		int b = Math.abs(y - x);
		if(a > b) {
			return b;
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char pointer = 'a';
		String s = sc.nextLine();
		int count = 0;
		int temp = 0;
		
		for(char c : s.toCharArray()) {
			temp = Math.abs(pointer - c);
			
			if(temp < 13) {
				count += temp;
			} else count += (26 - temp);
			pointer = c;
		}
		System.out.println(count);
	}
}
