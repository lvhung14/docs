package lecture01;

import java.util.ArrayList;
import java.util.Scanner;

public class Passwords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.nextLine();
		ArrayList<String> passwords = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			passwords.add(sc.nextLine());
		}
		String password = sc.nextLine();
		int smaller = 0;
		int equal = 0;
		for(String s : passwords) {
			if(s.length() < password.length()) {
				++smaller;
			}
			else if(s.length() == password.length() && !s.equals(password)) {
				++equal;
			}
		}
		int Best = smaller + (smaller/k)*5 + 1;
		int Worst = smaller + equal + ((equal + smaller)/k)*5 + 1;
		System.out.println(Best + " " + Worst);
	}
	
}
