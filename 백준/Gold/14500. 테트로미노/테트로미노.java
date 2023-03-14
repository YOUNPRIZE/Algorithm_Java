import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,max;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 완전탐색 돌리기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visit[i][j] = true;
				solve(i,j,map[i][j],1);
				visit[i][j] = false;
			}
		}

		System.out.println(max);	}
	static void solve(int x, int y, int sum, int count) {

		// 테트로미노 완성 시 수들의 합 계산
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}

		// 상하좌우 탐색
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 범위 벗어나면 예외 처리
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			// 아직 방문하지 않은 곳이라면
			if(!visit[nx][ny]) {

				// 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
				if(count == 2) {
					visit[nx][ny] = true;
					solve(x, y, sum + map[nx][ny], count + 1);
					visit[nx][ny] = false;
				}

				visit[nx][ny] = true;
				solve(nx, ny, sum + map[nx][ny], count + 1);
				visit[nx][ny] = false;
			}
		}
	}
}