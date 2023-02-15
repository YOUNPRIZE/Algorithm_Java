import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			sc.nextLine();
			for (int j = 0; j < N; j++) {
				
				String str = sc.nextLine();
				for (int k = 0; k < N; k++) {
					arr[j][k] = str.charAt(k);
				}
			}
			int[] d1 = {0, 1, 1, 1};
			int[] d2 = {1, 0, 1, -1};
			
			boolean checker = false;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] == 'o') {
						for (int a = 0; a < 4; a++) {
							int x = j;
							int y = k;
							
							int cnt = 0;
							
							while ((x >= 0 && x < N) && (y >= 0 && y < N) && (arr[x][y] == 'o')) {
								cnt++;
								x += d1[a];
								y += d2[a];
							}
							
							if (cnt >= 5) {
								checker = true;
								break;
							}
						}
					}
				}
			}
			if (checker) System.out.printf("#%d %s\n", i+1, "YES");
			else System.out.printf("#%d %s\n", i+1, "NO");
		}
	}
}