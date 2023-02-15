import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int[][] arr;
		StringTokenizer st;
		for (int test_case = 1; test_case<=10; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[100][102];
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}
			startX--;
			String direction = "up";
			while(startX > 0) {
				switch (direction) {
					case "up":
						// 양 쪽에 아무것도 없을 때
						if (arr[startX][startY-1] == 0 && arr[startX][startY+1] == 0) startX--;
						else if (arr[startX][startY-1] == 1) {
							startY--;
							direction = "left";
						} else if (arr[startX][startY+1] == 1) {
							startY++;
							direction = "right";
						}
						break;
					case "left":
						if (arr[startX-1][startY] == 1) {
							startX--;
							direction = "up";
						} else startY--;
						break;
					case "right":
						if (arr[startX+1][startY] == 1) {
							startX--;
							direction = "up";
						} else startY++;
						break;
				}
			}
			System.out.printf("#%d %d\n", test_case, startY-1);
		}
	}
}