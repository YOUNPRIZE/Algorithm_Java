import java.util.Scanner;

// SWEA3289. 서로소 집합
public class Solution {
	static int N,M;
	static int[] parent;
	
	static int getParent(int x) {
    	if (parent[x] == x) return x;
    	else return parent[x] = getParent(parent[x]);
    }
    
    static void unionParent(int x, int y) {
      x = getParent(x);
      y = getParent(y);
      
      if(x<y) 
    	  parent[y]=x;
      else 
    	  parent[x]=y;
    }
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = sc.nextInt();
			M = sc.nextInt();
			
			parent = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				int set = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				int big, small;
				if (a > b) {
					big = a;
					small = b;
				} else {
					big = b;
					small = a;
				}
			
				if (set == 0) {
					unionParent(small, big);
				} else {
					if (getParent(big) == getParent(small)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}