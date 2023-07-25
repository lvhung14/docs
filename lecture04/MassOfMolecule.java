package lecture04;
// CH(CO2H)3
import java.util.Scanner;
import java.util.Stack;

public class MassOfMolecule {
	static final int H = 1, C = 12, O = 16;

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		char[] c = sc.nextLine().toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] != '(' && c[i] != ')') {
				if (Character.isDigit(c[i])) {
					stack.add(stack.pop() * Character.getNumericValue(c[i]));
				}
				switch (c[i]) {
				case 'H':
					stack.add(1);
					break;
				case 'O':
					stack.add(16);
					break;
				case 'C':
					stack.add(12);
					break;
				default:
					break;
				}
			} else if (c[i] == '(') {
				stack.add(-1);
			} else {
				int count = 0;
				while (stack.peek() != -1) {
					count += stack.pop();
				}
				stack.pop();
				stack.add(count);
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
	}
}
