import java.util.Scanner;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[100][100];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) { 
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {
					arr[a][b] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						
						if (x >= 0 && x < 100 && y >= 0 && y < 100 && arr[x][y] == 0) cnt++;
						if (x < 0 || x >= 100 || y < 0 || y >= 100) cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
