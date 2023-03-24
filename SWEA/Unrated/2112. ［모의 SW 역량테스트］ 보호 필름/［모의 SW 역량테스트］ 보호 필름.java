import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int T, D, W, K, total;
    static int[][] graph, temp;
    static boolean[] visit;
    static Queue<int[]> q;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 총 테스트 케이스의 개수
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            // 보호 필름의 두께 (세로)
            D = sc.nextInt();
            // 보호 필름의 가로 크기 (가로)
            W = sc.nextInt();
            // 합격 기준
            K = sc.nextInt();
            graph = new int[D][W];
            temp = new int[D][W];
            visit = new boolean[D];
            total = Integer.MAX_VALUE;
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                	int AB = sc.nextInt();
                    graph[i][j] = temp[i][j] = AB;
                }
            }
            
            if (inspection(graph)) {
                sb.append(0).append("\n");
                continue;
            }
            
            // 테스트가 한 번에 통과 못했을 때
            // 
            // D개의 행 중에서 1부터 K까지 뽑아서 백트래킹
            dfs(0, 0);
            sb.append(total).append("\n");
        }	
        System.out.println(sb.toString());
    }
    
    public static void dfs(int cnt, int layer) {
        if (cnt >= total) return;
        
        if (layer == D) {
        	if (inspection(temp)) total = total > cnt ? cnt : total;
        	return;
        }
        
        dfs(cnt, layer+1);
        
        for (int i = 0; i < W; i++) {
        	temp[layer][i] = 0;
        }
        dfs(cnt+1, layer+1);
        
        for (int i = 0; i < W; i++) {
        	temp[layer][i] = 1;
        }
        dfs(cnt+1, layer+1);
        
        for (int i = 0; i < W; i++) {
        	temp[layer][i] = graph[layer][i];
        }
    }
    
    public static boolean inspection(int[][] arr) {
        for (int i = 0; i < W; i++) {
            int cnt = 1;
            for (int j = 0; j < D; j++) {
                if (j > 0) {
                    if (arr[j][i] == arr[j-1][i]) cnt++;
                    else cnt = 1;
                }
                
                if (cnt >= K) break;
                if (j == D - 1 && cnt != K) return false;
            }
        }
        return true;
    }
}