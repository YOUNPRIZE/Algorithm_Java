import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= 100; i++) {
            visited = new boolean[N][N];
            max = Math.max(max, bfs(i));
        }
        System.out.println(max);
    }
    
    private static int bfs(int n) {
        int cnt = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] || map[i][j] <= n) continue;
                visited[i][j] = true;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i, j});
                
                while(!q.isEmpty()) {
                    int[] arr = q.poll();
                    int curX = arr[0];
                    int curY = arr[1];
                    
                    for(int d = 0; d < 4; d++) {
                        int nr = dr[d] + curX;
                        int nc = dc[d] + curY;
                        
                        if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] <= n) continue;
                        
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
                cnt++;
            }
        }
        return cnt;
    }
}