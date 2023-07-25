package lecture04;

import java.util.Scanner;
import java.util.Stack;

public class Street_Parade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			Stack<Integer> pos = new Stack<>();
			int n = sc.nextInt();
			if(n == 0) break;
			int[] arr = new int[n];
			for(int i = 0; i < n ; i++) {
				arr[i] = sc.nextInt();
			}
			int i = 0;
			int count = 1;
			while(i < n) {
				if(arr[i] == count) {
					i++;
					count++;
				} else if(!pos.isEmpty() && pos.peek().equals(count)) {
					pos.pop();
					count++;
				} else pos.push(arr[i++]);
			}
			while(!pos.isEmpty() && pos.peek().equals(count)) {
				count++;
				pos.pop();
			}
			System.out.println(count == n + 1 ? "yes" : "no");
		}
	}
}
