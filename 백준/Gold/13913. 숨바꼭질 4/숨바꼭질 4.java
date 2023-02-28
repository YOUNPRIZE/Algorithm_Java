import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] arr;
	static int[] arr2;
	static int[] dx = {-1, 1, 2};
	static LinkedList<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[100001];
		arr2 = new int[100001];
		q = new LinkedList<>();
		// 수빈이의 위치
		N = Integer.parseInt(st.nextToken());
		// 동생의 위치
		K = Integer.parseInt(st.nextToken());
		
		// 수빈이의 위치 1로 설정
		if (N == K) {
			System.out.println(0);
			System.out.println(N);
		} else {
			bfs(N);	
			
			Stack<Integer> stack = new Stack<>();
			stack.push(K);
			int idx = K;
			
			while (idx != N) {
				stack.push(arr2[idx]);
				idx = arr2[idx];
			}
			
			while (!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
		}
	}
	
	static void bfs(int num) {
		q.add(N);
		arr[N] = 1;
		//arrStr[N] = String.valueOf(N);
		while(!q.isEmpty()) {
			int location = q.remove();
			if (location == K) {
				System.out.println(arr[location]-1);
				//System.out.println(arrStr[location] + " " + x);
				return;
			}
			for (int i = 0; i < 3; i++) {
				int x;
				if (i == 2) x = location * dx[i];
				else x = location + dx[i];
				
				
				if (x >= 0 && x <= 100000 && arr[x] == 0) {
					q.add(x);
					arr[x] = arr[location] + 1;
					arr2[x] = location;
				}
			}
		}
	}
}