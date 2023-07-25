package lecture03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GukiZ_and_Contest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> point = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			point.add(sc.nextInt());
		}
		ArrayList<Integer> reverse_point = new ArrayList<>(point);
		Collections.sort(reverse_point, Collections.reverseOrder());
		int[] rank = new int[5000];
		for (int i = 0; i < n; i++) {
			if (rank[reverse_point.get(i)] == 0) {
				rank[reverse_point.get(i)] = i + 1;
			}
		}
		for(int points : point) {
			System.out.print(rank[points] + " ");
		}
	}
}
