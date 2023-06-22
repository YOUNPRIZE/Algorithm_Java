import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    static int N, M, T, S, G, H;
    static int[] dist;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 교차로
            M = Integer.parseInt(st.nextToken()); // 도로
            T = Integer.parseInt(st.nextToken()); // 목적지 후보의 개수

            list = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken()); // 출발지
            G = Integer.parseInt(st.nextToken()); // G와 H 사이의 교차로를 지나감.
            H = Integer.parseInt(st.nextToken());
            // 도로
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list[from].add(new Node(to, cost));
                list[to].add(new Node(from, cost));
            }

            int[] ans = new int[N+1];

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            // 목적지 후보의 개수
            for (int i = 0; i < T; i++) {
                int destination = Integer.parseInt(br.readLine());
                long res1 = dijkstra(S, G) + dijkstra(G, H) + dijkstra(H, destination);
                long res2 = dijkstra(S, H) + dijkstra(H, G) + dijkstra(G, destination);
                long res3 = dijkstra(S, destination);
                if (Math.min(res1, res2) == res3) {
                    pq.add(destination);
                }
            }

            while (!pq.isEmpty()) {
                System.out.print(pq.poll() + " ");
            }
            System.out.println();
        }
        System.out.println(sb.toString());
    }
    public static int dijkstra(int start, int end) {
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visit = new boolean[N+1];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int cur = curNode.end;

            if (visit[cur]) continue;
            visit[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.cost) {
                    dist[node.end] = dist[cur] + node.cost;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end];
    }
}