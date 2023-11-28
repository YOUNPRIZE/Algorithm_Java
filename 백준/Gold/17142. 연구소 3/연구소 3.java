import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N, M;
    static int[][] map, temp;
    static boolean[][] visit;
    static boolean[] active;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Node> virus = new ArrayList<>();
    static int time = Integer.MAX_VALUE;
    static int zeroCount = 0;
    static Queue<Node> q;
//    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 연구소의 크기 N
        N = Integer.parseInt(st.nextToken());
        // 바이러스의 개수 M
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 일 때
                if (map[i][j] == 2) virus.add(new Node(i, j));
                // 벽일 때
                else if (map[i][j] == 1) map[i][j] = -1;
                // 길일 때
                else if (map[i][j] == 0) zeroCount++;
            }
        }
        if (zeroCount == 0) {
            System.out.println(0);
            return;
        }
        active = new boolean[virus.size()];
        dfs(0, 0);
//        if (flag) System.out.println(-1);
        if (time == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(time-1);
    }

    public static void bfs() {
        // 복사
        temp = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }

        q = new LinkedList<>();

        // 활성화
        for (int i = 0; i < virus.size(); i++) {
            Node node = virus.get(i);
            if(!active[i]) temp[node.x][node.y] = -2; // 비활성화 바이러스는 -2
            else {
                temp[node.x][node.y] = 1; // 활성화 바이러스는 -1
                visit[node.x][node.y] = true;
                q.add(new Node(node.x, node.y));
            }
        }

        int cnt = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                // 범위 벗어날 때
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 방문했을 때
                if (visit[nx][ny]) continue;

                // 벽 만났을 때
                if (temp[nx][ny] == -1) continue;

                // 바이러스 아닐 때
                if (temp[nx][ny] != -2) cnt++;

                temp[nx][ny] = temp[node.x][node.y] + 1;
                visit[nx][ny] = true;
                q.add(new Node(nx, ny));
            }
        }

        if (zeroCount != cnt) {
//            System.out.println(-1);
            return ;
        }

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < virus.size(); i++) {
            Node node = virus.get(i);
            if(!active[i]) {
                temp[node.x][node.y] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, temp[i][j]);
            }
        }


        time = Math.min(time, res);
    }

    public static void dfs(int start, int cnt) {
//        if (flag) return;
        // base case
        if (cnt == M) {
//            time = Math.min(time, bfs());
            bfs();
//            if (time == -1) flag = true;
            return; // 여기에 바이러스 퍼지는 메소드 구현하면 되려나
        }

        // recursive case
        for (int i = start; i < virus.size(); i++) {
            if (!active[i]) {
                active[i] = true;
                dfs(i + 1, cnt + 1);
                active[i] = false;
            }
        }
    }
}