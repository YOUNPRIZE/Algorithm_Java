import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent, depth;
    static List<Integer>[] tree;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        depth = new int[N + 1];
        tree = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        visit[1] = true;
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        init(1, 0);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void init(int x, int d) {
        visit[x] = true;
        depth[x] = d;
        for (int i : tree[x]) {
            if (visit[i]) continue;
            parent[i] = x;
            init(i, d + 1);
        }
    }

    static int LCA(int a, int b) {
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else if (depth[a] < depth[b]) {
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}