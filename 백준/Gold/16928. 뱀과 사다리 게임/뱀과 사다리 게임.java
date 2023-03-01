import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] game;
	static int[] check;
	static Queue<Integer> q;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		game = new int[101];
		check = new int[101];
		for (int i = 1; i <= 100; i++) {
			game[i] = i;
		}
		// 사다리의 수
		N = Integer.parseInt(st.nextToken());
		// 뱀의 수
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			game[idx] = move;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			game[idx] = move;
		}
		
		bfs(1);
	}
	
	private static void bfs(int start) {
		q = new LinkedList<>();
		q.add(start);
		check[start] = 0;
		while(!q.isEmpty()) {
			//cnt++;
			int idx = q.poll();
			//int movepoint = Integer.MIN_VALUE;
			for (int i = 1; i <= 6; i++) {
				int dx = idx + i;
				// continue 안해도 되지?
				if (dx > 100) continue;
				if (check[game[dx]] == 0) {
					q.add(game[dx]);
					check[game[dx]] = check[idx] + 1;
				}
				if (game[dx] == 100) {
					System.out.println(check[100]);
					return;
				}
 			}
			//q.add(movepoint);
		}
		//return cnt;
	}
}