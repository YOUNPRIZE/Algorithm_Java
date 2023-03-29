import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static int N;
	static double E;
	static int[] parents, coordX, coordY;
	static double[][] graph;
	static long ans;
	static ArrayList<Edge> list;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			list = new ArrayList<>();
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			parents = new int[N+1];
			coordX = new int[N+1];
			coordY = new int[N+1];
			graph = new double[N+1][N+1];
			for (int i = 1; i < N+1; i++) {
				coordX[i] = sc.nextInt();
			}
			for (int i = 1; i < N+1; i++) {
				coordY[i] = sc.nextInt();
			}
			
			E = sc.nextDouble();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i < j) {
						double xSquare = Math.pow(Math.abs(coordX[i]-coordX[j]), 2);
						double ySquare = Math.pow(Math.abs(coordY[i]-coordY[j]), 2);
						double dist = xSquare + ySquare;
//						double price = Math.pow(dist, 2);
//						graph[i][j] = price;
//						graph[j][i] = price;
						graph[i][j] = dist;
						graph[j][i] = dist;
					}
				}
			}
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(graph[i]));
//			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					list.add(new Edge(i,j,graph[i][j]));
				}
			}
			Collections.sort(list);
			
			make();
			
			int cnt = 0;
			ans = 0;
			for (Edge e : list) {
				if (unionSet(e.from, e.to)) {
					cnt++;
					ans += e.cost;
					if (cnt == N - 1) break;
				}
			}
//			System.out.println(ans);
			long res = Math.round(ans * E);
			sb.append(res).append("\n");
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
	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	private static int findSet(int v) {
		if (parents[v] == v) return v;
		return parents[v] = findSet(parents[v]);
	}
	
	private static boolean unionSet(int from, int to) {
		int fromRoot = findSet(from);
		int toRoot = findSet(to);
		
		if (fromRoot == toRoot) return false;
		parents[toRoot] = fromRoot;
		return true;
	}
}