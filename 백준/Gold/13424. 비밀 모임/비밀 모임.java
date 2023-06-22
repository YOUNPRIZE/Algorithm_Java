import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node (int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int N, M, K;
    static List<Node>[] list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N+1];

            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

            for (int i = 0 ; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Node(to, cost));
                list[to].add(new Node(from, cost));
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] ans = new int[N+1];
            for (int i = 0; i < K; i++) {
                int friend = Integer.parseInt(st.nextToken());
                dijkstra(friend);
                for (int j = 1; j <= N; j++) {
                    ans[j] += dist[j];
                }
            }
//            System.out.println(Arrays.toString(ans));
            int result = Integer.MAX_VALUE;
            int res = 0;
            for (int i = 1; i <= N; i++) {
//                result = Math.min(result, ans[i]);
                if (ans[i] < result) {
                    result = ans[i];
                    res = i;
                }
            }
//            System.out.println(res);
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void dijkstra(int start) {
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.cost) {
                    dist[node.end] = dist[cur] + node.cost;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }
}