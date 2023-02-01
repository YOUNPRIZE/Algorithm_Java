import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			int cnt = 0;
			
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean maxNum = true;
				
				for (int k = 0; k<q.size(); k++) {
					if(front[1]<q.get(k)[1]) {
						q.offer(front);
						for(int x = 0; x<k; x++) {
							q.offer(q.poll());
						}
						
						maxNum = false;
						break;
					}
				}
				
				if(maxNum == false) continue;
				
				cnt++;
				if (front[0] == M) break;
			}
			
			sb.append(cnt).append('\n');
			
		}
		System.out.println(sb);
	}
}
