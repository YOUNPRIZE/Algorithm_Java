import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int F,S,G,U,D;
	static int[] arr;
	static int[] updown;
	static LinkedList<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 제일 높은 층
		F = Integer.parseInt(st.nextToken());
		arr = new int[F];
		// 현재 위치해 있는 층 // -1 해주기 (배열의 index 때문)
		S = Integer.parseInt(st.nextToken());
		// 스타트링크가 있는 층 // -1 해주기 (배열의 index 때문)
		G = Integer.parseInt(st.nextToken());
		// 위로 U만큼 이동
		U = Integer.parseInt(st.nextToken());
		// 아래로 D만큼 이동
		D = Integer.parseInt(st.nextToken());
		
		updown = new int[] {U, D};
		
		System.out.println(bfs(S-1, G-1));
	}
	public static String bfs(int cur, int startlink) {
		q = new LinkedList<>();
		q.add(cur);
		arr[cur] = 1;
		while (!q.isEmpty()) {
			int location = q.remove();
            if (location == startlink) {
                return String.valueOf(arr[location]-1);
			}
			for (int i = 0; i < 2; i++) {
				int move;
				if (i == 0) move = location + updown[i];
				else move = location - updown[i];
				
				
				if (move >= 0 && move < F && arr[move] == 0) {
					arr[move] = arr[location] + 1;
					q.add(move);
				}
			}
		}
		return "use the stairs";
	}
}
