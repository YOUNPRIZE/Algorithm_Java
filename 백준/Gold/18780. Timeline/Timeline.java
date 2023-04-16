import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int to;
		int sec;
		public Node(int to, int sec) {
			this.to = to;
			this.sec = sec;
		}
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int[] origin = new int[N+1];
        int[] result = new int[N+1];
        
//        for (int i = 0; i < N; i++) {
//        	st = new StringTokenizer(br.readLine());
//        	origin[i] = Integer.parseInt(st.nextToken());
//        }
        
        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= str.length; i++) {
        	origin[i] = Integer.parseInt(str[i-1]);
        }
        
        result = origin.clone();
        
        List<Node>[] list = new List[N+1];
        int[] inDegree = new int[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        
        for (int i = 0; i < C; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int sec = Integer.parseInt(st.nextToken());
        	list[from].add(new Node(to, sec));
        	inDegree[to]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= N; i++) if (inDegree[i] == 0) q.add(i);
        
        while (!q.isEmpty()) {
        	int cur = q.poll();
        	
        	for (int i = 0; i < list[cur].size(); i++) {
        		result[list[cur].get(i).to] = Math.max(result[list[cur].get(i).to], result[cur] + list[cur].get(i).sec);
        		inDegree[list[cur].get(i).to]--;
        		if (inDegree[list[cur].get(i).to] == 0) q.add(list[cur].get(i).to);
        	}
        }
        for (int i = 1; i <= N; i++) {
        	System.out.println(result[i]);
        }
    }
}