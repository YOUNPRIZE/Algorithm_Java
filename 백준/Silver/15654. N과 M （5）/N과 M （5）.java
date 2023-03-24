import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num, sel;
    static boolean[] visit;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N + 1];
        visit = new boolean[N + 1];
        sel = new int[M];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
        System.out.println(sb.toString());
    }
    
    private static void dfs(int depth) {
        // base case
        if(depth == M) {
            for (int i = 0; i < sel.length; i++) {
            	sb.append(sel[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // recursive case
        for (int i = 1; i <= N; i++) {
        	if (visit[i]) continue;
        	sel[depth] = num[i];
        	visit[i] = true;
        	dfs(depth+1);
        	visit[i] = false;
        	
        }
    }
}