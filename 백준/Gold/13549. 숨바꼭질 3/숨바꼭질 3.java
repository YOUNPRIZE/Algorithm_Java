import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] arr;
	static int[] dx = {-1, 1, 2};
	static LinkedList<int[]> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[100001];
		q = new LinkedList<>();
		// 수빈이의 위치
		N = Integer.parseInt(st.nextToken());
		// 동생의 위치
		K = Integer.parseInt(st.nextToken());
		
		// 수빈이의 위치 1로 설정
//		if (N == K) {
//			System.out.println(0);
//		} else if (Math.sqrt(K/N) % 2 == 0) {
//			System.out.println(0);
//		} else {
//			bfs(N);	
//		}
		bfs(new int[] {N, 1});
	}
	
	static void bfs(int[] loc) {
		q.add(loc);
		arr[N] = 1;
		//int cnt = 0;
		while(!q.isEmpty()) {
			
			int location[] = q.remove();
			
			for (int i = 0; i < 3; i++) {
				int x;
				if (i == 2) {
					x = location[0] * dx[i];
//					if (x == K) {
//						System.out.println(arr[location]);
//						return;
//					}
					if (x >= 0 && x <= 100000 && (arr[x] == 0 || arr[x] > location[1])) {
						q.add(new int[] {x, location[1]});
						arr[x] = location[1];
						
					}
				} 
				else {
					//check = false;
					x = location[0] + dx[i];
//					if (x == K) {
//						System.out.println(arr[location]);
//						return;
//					}
					if (x >= 0 && x <= 100000 && (arr[x] == 0 || arr[x] > location[1] + 1)) {
						q.add(new int[] {x, location[1] + 1});
						arr[x] = location[1] + 1;
						
					}
				}
			}
		}
		System.out.println(arr[K]-1);
	}
}