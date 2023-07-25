package lecture04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Transform_The_Expression {
	private static void transformExpression(String a) {
		Stack<Character> expression = new Stack<>();
		for(int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if(Character.isLetter(c)) {
				System.out.print(c);
			} else if(c == ')') {
				System.out.print(expression.pop());
			} else if(c != '(') {
				expression.push(c);
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			arr.add(sc.nextLine());
			transformExpression(arr.get(i));
		}
	}
}
