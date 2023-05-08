import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K,L;
	static int[][] map;
	static Queue<int[]> apple;
	static Deque<int[]> snake;
	static Queue<Integer> turnL, turnR;
	static Queue<int[]> turn;
	static int dx = 0;
	static int dy = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 보드의 크기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// 사과의 개수
		K = Integer.parseInt(br.readLine());
		apple = new LinkedList<>();
		snake = new LinkedList<>();
		turnL = new LinkedList<>();
		turnR = new LinkedList<>();
		turn = new LinkedList<>();
		// 사과의 위치
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			apple.add(new int[] {x-1, y-1});
			map[x-1][y-1] = -1;
		}
		// 뱀의 방향 변환 정보
		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			String[] XC = br.readLine().split(" ");
			int X = Integer.parseInt(XC[0]);
			String C = XC[1];
//			if (C.equals("L")) turnL.add(X);
//			else turnR.add(X);
			if (C.equals("L")) turn.add(new int[] {X, -1});
			else turn.add(new int[] {X, -2});
			
		}
		int cx = 0;
		int cy = 0;
		int sec = 0;
		snake.add(new int[] {cx, cy});
		
		loop: while(true) {
			sec++;
			cx = cx + dx;
			cy = cy + dy;
//			System.out.println(cx + " " + cy);
			if (cx < 0 || cy < 0 || cx >= N || cy >= N) break;
//			if (snake.contains(new int[]{cx, cy})) {
//				System.out.println("sibale");
//				break;
//			}
			for (int i = 0; i < snake.size(); i++) {
				int[] sxy = snake.poll();
				int sx = sxy[0];
				int sy = sxy[1];
				if (sx == cx && sy == cy) break loop;
				snake.add(new int[] {sx, sy});
			}
			snake.add(new int[] {cx,cy});
//			if (!apple.contains(new int[] {cx, cy})) {
//				snake.pollFirst();
//			}
			if (map[cx][cy] != -1) {
				snake.pollFirst();
			} else {
				map[cx][cy] = 0;
			}
//			System.out.println(turn.peek());
			if (!turn.isEmpty() && turn.peek()[0] == sec) {
				int dir = turn.peek()[1];
				
				if (dir == -1) {
					change("L");
				} else  {
					change("R");
				}
				turn.poll();
			}
		}
		System.out.println(sec);
	}
	
	public static void change(String direct) {
		if(dx == 0 && dy == 1) {
			if (direct.equals("R")) {
				dy = 0;
				dx = 1;
			} else {
				dy = 0;
				dx = -1;
			}
		} else if (dx == 0 && dy == -1) {
			if (direct.equals("R")) {
				dy = 0;
				dx = -1;
			} else {
				dy = 0;
				dx = 1;
			}
		} else if (dx == 1 && dy == 0) {
			if (direct.equals("R")) {
				dy = -1;
				dx = 0;
			} else {
				dy = 1;
				dx = 0;
			}
		} else if (dx == -1 && dy == 0) {
			if (direct.equals("R")) {
				dy = 1;
				dx = 0;
			} else {
				dy = -1;
				dx = 0;
			}
		}
	}
}