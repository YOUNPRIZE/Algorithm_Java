import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] arr;
	static int[] dx = {-1, 1, 2};
	static LinkedList<Integer> q;
	static int cnt = 0;
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
		if (N >= K) {
			System.out.println(N-K);
			System.out.println(1);
		} else {
			bfs(N);	
		}
	}
	
	static void bfs(int num) {
		q.add(N);
		arr[N] = 1;
		int time = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int location = q.remove();
			
			if (time < arr[location]) break;
			
			for (int i = 0; i < 3; i++) {
				int x;
				if (i == 2) x = location * dx[i];
				else x = location + dx[i];
				
				if (x == K) {
//					System.out.println(arr[location]);
//					return;
					if (arr[x] == 0) {
						cnt++;
						arr[x] = arr[location];
						time = arr[location];
					} else {
						if (arr[x] > arr[location]) {
							arr[x] = arr[location];
							time = arr[location];
							cnt = 1;
						} else if (arr[x] == arr[location]) {
							cnt++;
						}
					}
				}
				if (x >= 0 && x <= 100000 && (arr[x] == 0 || arr[x] == arr[location] + 1)) {
					q.add(x);
					arr[x] = arr[location] + 1;
					
				}
			}
		}
		System.out.println(arr[K]);
		System.out.println(cnt);
	}
}