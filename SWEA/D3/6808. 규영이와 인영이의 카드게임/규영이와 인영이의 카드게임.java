import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static boolean[] total, visited;
	static int[] kyu, in, result;
	static int kyuGrade, inGrade, totalWin, totalLose;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			total = new boolean[19];
			kyu = new int[9];
			in = new int[9];
			visited = new boolean[9];
			result = new int[9];
			totalWin = 0;
			totalLose = 0;
			for (int i = 0; i < 9; i++) {
				kyu[i] = sc.nextInt();
				total[kyu[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i < total.length; i++) {
				if (!total[i]) in[idx++] = i; 
			}
			perm(0);
			System.out.printf("#%d %d %d\n", tc, totalWin, totalLose);
		}
	}
	
	public static void perm(int idx) {
		if (idx == 9) {
			kyuGrade = 0;
			inGrade = 0;
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > result[i]) kyuGrade += kyu[i] + result[i];
				else inGrade += kyu[i] + result[i];
			}
			if (kyuGrade > inGrade) totalWin++;
			else if (kyuGrade < inGrade) totalLose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (visited[i]) continue;
			
			result[idx] = in[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
}