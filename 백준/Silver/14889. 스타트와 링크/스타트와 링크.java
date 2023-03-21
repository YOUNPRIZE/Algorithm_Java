import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14889. 스타트와 링크 (실버2)
public class Main {
	static int N, cntA, cntB, min;
	static int[][] graph;
	static int[] ingA, ingB, coor;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); 
		ingA = new int[N/2];
		ingB = new int[N/2];
		coor = new int[2];
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//check = 0;
		min = Integer.MAX_VALUE;
		recur(0, 0);
		System.out.println(min);
	}
	// N개의 식재료를 N/2씩 두 그룹으로 나누는 메소드
	public static void recur(int idx, int sidx) {
		// N개 중 N/2 씩 두 그룹으로 뽑을 때 절반 이상은 중복되므로 return 해준다.
		//if (check >= comb(N)/2) return;
		// base case
		// 전부 뽑았을 때
		if (sidx == N/2) {
			// 안뽑힌 것에 대해 dselect 배열을 초기화 해준다.
			int index = 0;
			for (int i = 0; i < N; i++) {
				boolean check = false;
				for (int j = 0; j < N/2; j++) {
					if (i + 1 == ingA[j]) check = true; 
				}
				if(!check) ingB[index++] = i+1;
			}
			
			// A, B 그룹으로 나뉘었을 때 시너지 계산을 해주는 과정
			cntA = 0;
			cntB = 0;
			recur2(0, 0, ingA, 'A');
			recur2(0, 0, ingB, 'B');
			
			// min 값을 A,B 시너치차와 비교를 통해 계속해서 update
			min = Math.min(Math.abs(cntA-cntB), min);
			//check++;
			return;
			
		}
		// 전부 고려했을 때
		if (idx == N) return;
		
		// recursive case
		ingA[sidx] = idx + 1;
		recur(idx + 1, sidx + 1);
		recur(idx + 1, sidx);
	}
	
	// 시너지 전부 더해주는 메소드
	public static void recur2(int idx, int sidx, int[] arr, char AB) {
		// base case
		// 전부 뽑았을 때
		if (sidx == 2) {
			// 시너지 전부 더해주는 과정
			for (int i = 0; i < arr.length; i++) {
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
		// 전부 고려했을 때
		if (idx == arr.length) return;
		
		// recursive case
		coor[sidx] = arr[idx];
		recur2(idx + 1, sidx + 1, arr, AB);
		recur2(idx + 1, sidx, arr, AB);
	}
	
	// N개 중 N/2개 뽑을 때의 경우의 수
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