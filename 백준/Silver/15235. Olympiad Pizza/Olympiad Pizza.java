import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Numb {
		int idx;
		int portion;
		
		public Numb(int idx, int portion) {
			this.idx = idx;
			this.portion = portion;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Numb> q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int por = Integer.parseInt(st.nextToken());
			q.add(new Numb(i+1, por));
		}
		int time = 0;
		int[] arr = new int[N];
		while(!q.isEmpty()) {
			time++;
			Numb ele = q.poll();
			if (ele.portion == 1) {
				arr[ele.idx - 1] = time;
			} else {
				ele.portion--;
				q.add(ele);
			}
		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
//		System.out.println(Arrays.toString(arr));
	}
}