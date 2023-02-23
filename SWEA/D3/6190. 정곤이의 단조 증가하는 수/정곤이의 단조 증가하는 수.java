
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Queue<Integer> q;
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					q.add(arr[i] * arr[j]);
				}
			}
			int max = 0;
//			for (int i : q) {
//				String str = Integer.toString(i);
//				//System.out.println(i);
//				if (str.length() > 1) {
//					boolean check = true;
//					int num = 0;
//					for (int j = 0; j < str.length(); j++) {
//						if (j == 0) num = str.charAt(j) - '0';
//						else {
//							if (str.charAt(j) - '0' >= num) num = str.charAt(j) - '0';
//							else {
//								check = false;
//								break;
//							}
//						}
//					}
//					if (!check) continue;
//					else {
//						if (i > max) max = i;
//					}
//				} else {
//					if (i > max) max = i;
//				}
//			}
			while (!q.isEmpty()) {
				int i = q.poll();
				String str = Integer.toString(i);
				//System.out.println(i);
				if (str.length() > 1) {
					boolean check = true;
					int num = 0;
					for (int j = 0; j < str.length(); j++) {
						if (j == 0) num = str.charAt(j) - '0';
						else {
							if (str.charAt(j) - '0' >= num) num = str.charAt(j) - '0';
							else {
								check = false;
								break;
							}
						}
					}
					if (!check) continue;
					else {
						if (i > max) max = i;
					}
				} else {
					if (i > max) max = i;
				}
			}
			System.out.print("#" + tc + " ");
			if (max == 0) System.out.println(-1);
			else System.out.println(max);
		}
	}
}
