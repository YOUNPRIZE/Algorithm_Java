import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int N;
	static double E;
	static int[] coordX, coordY;
	//static double[][] graph;
	static long ans;
	static ArrayList<Edge> list;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			coordX = new int[N+1];
			coordY = new int[N+1];
			//graph = new double[N+1][N+1];
			for (int i = 1; i < N+1; i++) {
				coordX[i] = sc.nextInt();
			}
			for (int i = 1; i < N+1; i++) {
				coordY[i] = sc.nextInt();
			}
			
			List<Edge>[] adjList = new ArrayList[N+1];
			
			
			
			for(int i = 0 ; i<N+1; i++) {
				adjList[i] = new ArrayList<>();
			}
//			System.out.println(Arrays.toString(adjList));
			E = sc.nextDouble();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i < j) {
						double xSquare = Math.pow(Math.abs(coordX[i]-coordX[j]), 2);
						double ySquare = Math.pow(Math.abs(coordY[i]-coordY[j]), 2);
						double dist = xSquare + ySquare;
//						graph[i][j] = dist;
//						graph[j][i] = dist;
						adjList[i].add(new Edge(i,j,dist));
						adjList[j].add(new Edge(j,i,dist));
					}
				}
			}
//			for (int i = 0; i < adjList.length; i++) {
//				System.out.println(adjList[i]);
//			}
			boolean[] visit = new boolean[N+1];
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			visit[1] = true;
			
			pq.addAll(adjList[1]);
			
			int pick = 1; 
			ans = 0;
			
			while(pick != N) {
				Edge e = pq.poll();
				if (visit[e.to]) continue;
				
				ans += e.cost;
				pq.addAll(adjList[e.to]);
				visit[e.to] = true;
				pick++;
			}
			long res = Math.round(ans * E);
			sb.append(res).append("\n");
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					list.add(new Edge(i,j,graph[i][j]));
//				}
//			}
//			// 비용순으로 정렬
//			Collections.sort(list);
//			
//			make();
//			
//			int cnt = 0;
//			ans = 0;
//			for (Edge e : list) {
//				// 이어져 있다면
//				if (unionSet(e.from, e.to)) {
//					// 간선 추가
//					cnt++;
//					// 비용 추가
//					ans += e.cost;
//					// 다 이어졌으면 for문 탈출
//					if (cnt == N - 1) break;
//				}
//			}
//			long res = Math.round(ans * E);
//			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double cost;
		
		public Edge(int from, int to, double cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
	}
}