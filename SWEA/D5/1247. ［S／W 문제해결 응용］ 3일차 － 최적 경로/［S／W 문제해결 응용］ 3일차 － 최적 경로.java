import java.util.Scanner;

public class Solution {
	static int N, min;
	static int[][] graph;
	static int[] result;
	static boolean[] visit;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
//			System.out.print("#"+tc+" ");
			N = sc.nextInt();
			
			graph = new int[N+2][2];
			result = new int[N+2];
			visit = new boolean[N+2];
			sc.nextLine();
			String[] coords = sc.nextLine().split(" ");
			
			graph[0][0] = Integer.parseInt(coords[0]);
			graph[0][1] = Integer.parseInt(coords[1]);
			graph[N+1][0] = Integer.parseInt(coords[2]);
			graph[N+1][1] = Integer.parseInt(coords[3]);
			
			for (int i = 2; i < N + 2; i++) {
				graph[i-1][0] = Integer.parseInt(coords[2 * i]);
				graph[i-1][1] = Integer.parseInt(coords[2 * i + 1]);
			}
			
			min = Integer.MAX_VALUE;
			perm(1);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
//			System.out.println(min);
		}
		System.out.println(sb.toString());
	}
	
	public static void perm(int idx) {
		if (idx == N + 1) {
			int sum = 0;
			for (int i = 0; i < N + 1; i++) {
				sum += Math.abs(Math.abs(graph[result[i]][0]-graph[result[i+1]][0]) + Math.abs(graph[result[i]][1]-graph[result[i+1]][1]));
			}
			min = Math.min(min, sum);
			return;
		}
		
		result[0] = 0;
		visit[0] = true;
		
		result[N+1] = N+1;
		visit[N+1] = true;
		
		for (int i = 1; i < N+1; i++) {
			if (visit[i]) continue;
			result[idx] = i;
			visit[i] = true;
			perm(idx + 1);
			visit[i] = false;
		}
	}
}