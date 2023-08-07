import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, k;
    static int[] parent;
    static int[] cost;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) parent[i] = i;

        cost = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (!isUnion(v, w)) union(v, w);
        }

        for (int i = 1; i <= N; i++) {
            parent[i] = parent[parent[i]];
        }

        int res = 0;
        for(int i = 1; i <= N; i++){
            int rootIdx = find(i);

            if(visit[rootIdx]){
                visit[i] = true;
                continue;
            }
            // 1 2 1 2 2
            res += cost[rootIdx];

            visit[rootIdx] = true;
            visit[i] = true;
        }

        if (k >= res) System.out.println(res);
        else System.out.println("Oh no");
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return find(parent[x]);
    }

    public static void union(int x, int y) {
        if (cost[find(x)] < cost[find(y)]) parent[find(y)] = find(x);
        else parent[find(x)] = find(y);
    }

    public static boolean isUnion(int x, int y) {
        if (parent[x] == parent[y]) return true;
        else return false;
    }
}