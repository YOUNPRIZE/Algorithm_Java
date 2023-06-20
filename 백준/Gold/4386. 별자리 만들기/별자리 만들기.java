import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double[][] graph;
    static double[][] coor;
    static int[] parents;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double cost;

        public Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return (int) (this.cost - o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        graph = new double[N][N];
        coor = new double[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coor[i][0] = Double.parseDouble(st.nextToken());
            coor[i][1] = Double.parseDouble(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                double x = Math.abs(coor[i][0] - coor[j][0]);
                double y = Math.abs(coor[i][1] - coor[j][1]);
                double dist = Math.sqrt(x * x + y * y);
//                System.out.println(dist);
                edgeList.add(new Edge(i,j,dist));
            }
        }

        Collections.sort(edgeList);

        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        double ans = 0;
        for (Edge e : edgeList) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                ans += e.cost;
                cnt++;
                if (cnt == N-1) break;
            }
        }
//        System.out.println(ans);
        System.out.println(String.format("%.2f", ans));
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        parents[find(x)] = find(y);
    }
}