import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] turns = new int[10];
	static int[] normal = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1};
	static int[] specialTen = {10, 13, 16, 19, 25, 30, 35, 40, -1};
	static int[] specialTwenty = {20, 22, 24, 25, 30, 35, 40, -1};
	static int[] specialThirty = {-30, 28, 27, 26, 25, 30, 35, 40, -1};
	// normal 0
	// ten 1
	// twenty 2
	// thirty 3
	// {0, 0} -> {현재있는 칸, 이동방식}
	static int[][] knights = {{0, 0}, {0, 0},{0, 0},{0, 0}};
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 10개의 턴
		for (int i = 0; i < 10; i++) turns[i] = Integer.parseInt(st.nextToken());
		dfs(0, 0, knights);
		System.out.println(result);
	}
	
	public static void dfs(int turn, int score, int[][] knightStatus) {
		// base case
		if (turn == 10) {
			result = Math.max(result, score);
			return;
		}
		
		// recursive case
		for (int i = 0; i < 4; i++) {
			if (knightStatus[i][0] == -1) continue;
			int[] next = move(i, turns[turn], knightStatus);
			boolean check = true;
			for (int j = 0; j < 4; j++) {
				if (i != j) {
					if (next[1] == 0 && next[0] == 40) {
						if (next[0] == knightStatus[j][0]) {
							check = false;
							break;
						}
					} else if (next[1] == 1 || next[1] == 2 || next[1] == 3) {
						if (next[0] == 25 || next[0] == 30 || next[0] == 35 || next[0] == 40) {
							if (next[0] == knightStatus[j][0]) {
								check = false;
								break;
							}
						}
					}
					if (knightStatus[j][0] == next[0] && knightStatus[j][1] == next[1]) {
						if (next[0] == -1) continue;
						check = false;
						break;
					}
				}
			}
			if (!check) continue;
			int[][] temp = new int[4][2];
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					temp[j] = next;
				} else temp[j] = knightStatus[j];
			}
			if (next[0] == -1) dfs(turn+1, score, temp);
			else dfs(turn+1, score + Math.abs(next[0]), temp);
		}
	}
	
	public static int[] move(int idx, int moving, int[][] knightStatus) {
		int[] knight = knightStatus[idx];
		int[] next;
		// normal에 있을 때
		if (knight[1] == 0) {
			int newIdx = 0;
			for (int i = 0; i < normal.length; i++) {
				if (normal[i] == knight[0]) {
					newIdx = i + moving;
					break;
				}
			}
//			if (normal[newIdx] == 10) {
//				next = new int[] {10, 1};
//			} else if (normal[newIdx] == 20) {
//				next = new int[] {20, 2};
//			} else if (normal[newIdx] == 30) {
//				next = new int[] {30, 3};
//			} else if (newIdx >= normal.length - 1) {
//				next = new int[] {-1, 0};
//			} else next = new int[] {normal[newIdx], 0};
			
			if (newIdx >= normal.length - 1) {
				next = new int[] {-1, 0};
			} else if (normal[newIdx] == 20) {
				next = new int[] {20, 2};
			} else if (normal[newIdx] == 30) {
				next = new int[] {-30, 3};
			} else if (normal[newIdx] == 10) {
				next = new int[] {10, 1};
			} else next = new int[] {normal[newIdx], 0};
		// ten에 있을 때
		} else if (knight[1] == 1) {
			int newIdx = 0;
			for (int i = 0; i < specialTen.length; i++) {
				if (specialTen[i] == knight[0]) {
					newIdx = i + moving;
					break;
				}
			}
			if (newIdx >= specialTen.length - 1) next = new int[] {-1, 1};
			else next = new int[] {specialTen[newIdx], 1};
		// Twenty에 있을 때
		} else if (knight[1] == 2) {
			int newIdx = 0;
			for (int i = 0; i < specialTwenty.length; i++) {
				if (specialTwenty[i] == knight[0]) {
					newIdx = i + moving;
					break;
				}
			}
			if (newIdx >= specialTwenty.length - 1) next = new int[] {-1, 2};
			else next = new int[] {specialTwenty[newIdx], 2};
		// Thirty에 있을 때
		} else {
			int newIdx = 0;
			for (int i = 0; i < specialThirty.length; i++) {
				if (specialThirty[i] == knight[0]) {
					newIdx = i + moving;
					break;
				}
			}
			if (newIdx >= specialThirty.length - 1) next = new int[] {-1, 3};
			else next = new int[] {specialThirty[newIdx], 3};
		}
		return next;
	}
}