package lecture01;

import java.util.ArrayList;
import java.util.Scanner;

public class FashionInBerland {
	private static boolean checkJacket(ArrayList<Integer> v, int n) {
        if (n == 1) {
            if (v.get(0) == 1)
                return true;
            else
                return false;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (v.get(i) == 0) {
                count++;
            }
        }
        if (count == 1)
            return true;
        else
            return false;
    }
	public static boolean checkFastened(ArrayList<Integer> arr, int button) {
		if(button == 1) {
			if(arr.get(0) == 1) return true;
			else return false;
		} 
		int count = 0;
		int count1 = 0;
		for(int i = 0; i < button; i++) {
			if(arr.get(i) == 0) {
				count++;
			}
			if(arr.get(i) == 1) {
				count1 ++;
			}
		}
		if(count1 == button) return false;
		if(count < 2) return true;
		return false;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int button = sc.nextInt();
		for(int i = 0; i < button; i++) {
			arr.add(sc.nextInt());
		}
		if(checkFastened(arr, button)) {
			System.out.println("YES");
		} else System.out.println("NO");
	}
}
