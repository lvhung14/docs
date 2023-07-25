package lecture03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Towers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> tower = new ArrayList<>();
		for(int i = 0; i < n ; i++) {
			tower.add(sc.nextInt());
		}
		int [] temp = new int[1001];
		int diff = 0;
		for(int i = 0; i < n; i++) {
			if(temp[tower.get(i)] == 0) {
				diff++;
				temp[tower.get(i)]++;
			}
			else temp[tower.get(i)]++;
		}
		Arrays.sort(temp);
		System.out.println(temp[1000] + " " + diff);
	}
}
