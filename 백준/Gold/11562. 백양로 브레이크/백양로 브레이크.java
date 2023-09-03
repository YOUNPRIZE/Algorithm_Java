import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k;
    static int[][] map;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
             for (int j = 1; j <= N; j++) {
                 if (i != j) map[i][j] = INF;
             }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b == 1) {
                map[u][v] = 0;
                map[v][u] = 0;
            } else {
                map[u][v] = 0;
                map[v][u] = 1;
            }
        }
//        for (int i = 0; i <= N; i++) System.out.println(Arrays.toString(map[i]));
//        System.out.println();
        k = Integer.parseInt(br.readLine());

        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if (s == e) continue;
                    if (map[s][e] > map[s][m] + map[m][e]) map[s][e] = map[s][m] + map[m][e];
                }
            }
        }

//        for (int i = 0; i <= N; i++) System.out.println(Arrays.toString(map[i]));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(map[a][b]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
