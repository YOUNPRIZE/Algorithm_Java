import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R,C;
    static int cnt = 0;
    static int[][] graph;
    static boolean[] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        graph = new int[R][C];
        visit = new boolean[26];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j) - 'A';
            }
        }
        dfs(0,0,0);
        
        System.out.println(cnt);
    }
    
    public static void dfs(int x, int y, int count) {
        // base case
       if (visit[graph[x][y]]) {
    	   cnt = Math.max(cnt, count);
    	   return;
       } else {
    	   visit[graph[x][y]] = true;
    	   for (int i = 0; i < 4; i++) {
    		   int cx = x + dx[i];
    		   int cy = y + dy[i];
    		   
    		   if (cx >= 0 && cy >= 0 && cx < R && cy < C) {
    			   dfs(cx, cy, count + 1);
    		   }
    	   }
    	   visit[graph[x][y]] = false;
       }
    }
}