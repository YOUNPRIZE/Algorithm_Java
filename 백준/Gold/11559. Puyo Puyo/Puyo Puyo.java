import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] graph = new char[12][6];
    static boolean[][] visit;
    static boolean isDown;
    static Queue<int[]> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                graph[i][j] = str.charAt(j);
//                System.out.println(graph[i][j]);
            }
        }

        int ans = 0;

        while(true) {
            isDown = false;
            puyo();
            if (!isDown) break;
            gravity();
            ans++;
        }
        System.out.println(ans);
    }

    public static void puyo() {
        visit = new boolean[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (!visit[i][j]) {
                    // R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑
                    if (graph[i][j] == 'R') {
                        bfs(i, j, 'R');
                    } else if (graph[i][j] == 'G') {
                        bfs(i, j, 'G');
                    } else if (graph[i][j] == 'B') {
                        bfs(i, j, 'B');
                    } else if (graph[i][j] == 'P') {
                        bfs(i, j, 'P');
                    } else if (graph[i][j] == 'Y') {
                        bfs(i, j, 'Y');
                    }
                }
            }
        }
    }

    public static void gravity() {
        Queue<Character> color = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                if (graph[j][i] != '.') {
                    color.add(graph[j][i]);
                    graph[j][i] = '.';
                }
            }
            int x = 11;
            while (!color.isEmpty()) {
                graph[x--][i] = color.poll();
            }
        }
    }

    public static void bfs(int x, int y, char color) {
        q = new LinkedList<>();
        char[][] temp = new char[12][6];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                temp[i][j] = graph[i][j];
            }
        }
        temp[x][y] = '.';
        int cnt = 1;
        visit[x][y] = true;
        q.add(new int[] {x, y});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if (!visit[nx][ny] && graph[nx][ny] == color) {
                    visit[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                    temp[nx][ny] = '.';
                    cnt++;
                }
            }
        }
        if (cnt >= 4) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    graph[i][j] = temp[i][j];
                }
            }
            isDown = true;
        }
    }
}