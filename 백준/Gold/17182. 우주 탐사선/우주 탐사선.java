import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K, res;
    static int[][] map;
    static boolean[] visit;
    public static boolean checkTrue(boolean[] visited) {
        boolean check = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) check = false;
        }
        return check;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N];
        res = Integer.MAX_VALUE;
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if (map[s][e] > map[s][m] + map[m][e]) map[s][e] = map[s][m] + map[m][e];
                }
            }
        }

//        for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));

        visit[K] = true;
        dfs(0, visit, K);

        System.out.println(res);
    }
    public static void dfs(int time, boolean[] visited, int idx) {
//        visited[idx] = true;

        if (checkTrue(visited)) {
//            System.out.println(res);
            res = Math.min(time, res);
            return;
        }

        for (int i = 0; i < N; i++) {
//            if (i != K && map[idx][i] != 0 && time + map[idx][i] < res) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(time + map[idx][i], visited, i);
                    visited[i] = false;
                }
//            }
        }
    }
}