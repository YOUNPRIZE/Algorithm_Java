import java.util.Arrays;
import java.util.Scanner;

// 4012. 요리사
public class Solution {
	static int N, check, cntA, cntB, min;
	static int[][] graph;
	static int[] ingA, ingB, coor;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			ingA = new int[N/2];
			ingB = new int[N/2];
			coor = new int[2];
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			check = 0;
			
			min = Integer.MAX_VALUE;
			recur(0, 0);
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	
	public static void recur(int idx, int sidx) {
		if (check >= comb(N)/2) return;
		// base case
		if (sidx == N/2) {
//			System.out.print("ingA : ");
//			System.out.print(Arrays.toString(ingA));
			int index = 0;
			for (int i = 0; i < N; i++) {
				boolean check = false;
				for (int j = 0; j < N/2; j++) {
					if (i + 1 == ingA[j]) check = true; 
				}
				if(!check) ingB[index++] = i+1;
			}
//			System.out.print(", ingB : ");
//			System.out.println(Arrays.toString(ingB));
			
			cntA = 0;
			cntB = 0;
			recur2(0, 0, ingA, 'A');
//			System.out.print("fasdfasdfasdf");
//			System.out.println(cntA);
			recur2(0, 0, ingB, 'B');
//			System.out.print("fasdfasdfasdf");
//			System.out.println(cntB);
			min = Math.min(Math.abs(cntA-cntB), min);
			check++;
			return;
			
		}
		if (idx == N) return;
		
		// recursive case
		ingA[sidx] = idx + 1;
		recur(idx + 1, sidx + 1);
		ingB[sidx] = idx + 1;
		recur(idx + 1, sidx);
	}
	
	public static void recur2(int idx, int sidx, int[] arr, char AB) {
		// base case
		if (sidx == 2) {
			for (int i = 0; i < arr.length; i++) {
//				System.out.println(Arrays.toString(coor));
				
				if (AB == 'A') {
					cntA += graph[coor[0]-1][coor[1]-1];
					cntA += graph[coor[1]-1][coor[0]-1];
				} else {
					cntB += graph[coor[0]-1][coor[1]-1];
					cntB += graph[coor[1]-1][coor[0]-1];
				}
				return;
			}
		}
		if (idx == arr.length) return;
		
		// recursive case
		coor[sidx] = arr[idx];
		recur2(idx + 1, sidx + 1, arr, AB);
		recur2(idx + 1, sidx, arr, AB);
	}
	public static int comb(int N) {
		int num = 1;
		int mid = N / 2;
		while(N > 0) {
			if (N > mid) num *= N--;
			else num /= N--;
		} 
		return num;
	}
}
