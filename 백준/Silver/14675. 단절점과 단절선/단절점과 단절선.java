import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, q;
    static ArrayList<Integer>[] tree;
//    static int[][] order;
//    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
//        order = new int[N][2];
        StringTokenizer st;
        tree = new ArrayList[N + 1];
//        parent = new int[N+1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
//            parent[b] = a;
//            order[i][0] = a;
//            order[i][1] = b;
        }

        q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // 단절점
            if (t == 1) {
                if (tree[k].size() >= 2) System.out.println("yes");
                else System.out.println("no");
            // 단절선
            } else {
                System.out.println("yes");
            }
        }
    }
}