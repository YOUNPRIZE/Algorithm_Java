import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int N, r1, c1, r2, c2;
    static int[][] map;
    static boolean[][] visit;
    static Queue<int[]> q;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        String[] str = br.readLine().split(" ");
        r1 = Integer.parseInt(str[0]);
        c1 = Integer.parseInt(str[1]);
        r2 = Integer.parseInt(str[2]);
        c2 = Integer.parseInt(str[3]);
        
        //map[r1][c1] = 1;
        
        if(r1 == r2 && c1 == c2) {
            System.out.println(0);
        } else {
            bfs(r1, c1);
            System.out.println(map[r2][c2] == 0 ? -1 : map[r2][c2]);
        }
    }
    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[] {x, y});
        visit[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] ele = q.poll();
            if (ele[0] == r2 && ele[1] == c2) break;
            for (int i = 0; i < 6; i++) {
                int nx = ele[0] + dx[i];
                int ny = ele[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                q.add(new int[] {nx, ny});
                visit[nx][ny] = true;
                map[nx][ny] = map[ele[0]][ele[1]] + 1;
            }
        }
    }
}