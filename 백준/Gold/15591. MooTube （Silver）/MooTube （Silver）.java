import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, Q;
    static class Node {
        int to;
        int weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static List<Node>[] list;
    static boolean[] visit;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list[p].add(new Node(q, r));
            list[q].add(new Node(p, r));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            visit = new boolean[N+1];
            visit[v] = true;
            q = new LinkedList<>();
            q.add(v);
            int ans = 0;
            while(!q.isEmpty()) {
                int idx = q.poll();
                for (int j = 0; j < list[idx].size(); j++) {
                    Node node = list[idx].get(j);
                    if (!visit[node.to] && node.weight >= k) {
                        visit[node.to] = true;
                        q.add(node.to);
                        ans++;
                    }
                }
            }
//            System.out.println(ans);
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}