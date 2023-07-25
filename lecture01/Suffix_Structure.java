package lecture01;

import java.util.Scanner;

public class Suffix_Structure {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		boolean array = false, automaton = false, need_tree = false;
		int[] sCount = new int [26];
		int[] tCount = new int [26];
		
		for(int i = 0; i < s.length(); i++) {
			sCount[s.charAt(i) - 'a']++;
		}
		for(int i = 0; i < t.length(); i++) {
			tCount[t.charAt(i) - 'a']++;
		}
		for(int i = 0; i < 26; i++) {
			if(tCount[i] > sCount[i]) {
				need_tree = true;
			} else if (tCount[i] > sCount[i]) automaton = true;
		}
		int index = 0, match = -1;
		for(int i = 0; i < t.length(); i++) {
			index = s.indexOf(t.charAt(i), match + 1);
			if(index > match) {
				match = index;
			} else {
				array = true;
				break;
			}
		}
		if (need_tree) {
            System.out.print("need tree");
        }
        else if (automaton && array) {
            System.out.print("both");
        }
        else if (automaton) {
            System.out.print("automaton");
        }
        else {
            System.out.print("array");
        }
	}
}
