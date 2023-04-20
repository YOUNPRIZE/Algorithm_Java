import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
    static int[][] result;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        result = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) Arrays.fill(result[i], INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            result[start][to] = cost;
        }
        
//        int answer = Integer.MAX_VALUE; // 사이클에 속하는 간선 중 가장 작은 값을 저장할 변수 초기화
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
//                if (i == j || result[i][j] == Integer.MAX_VALUE) continue; // 자기 자신과의 거리는 제외
                for (int j = 1; j <= V; j++) {
//                    if (j == k || i == k || result[j][k] == Integer.MAX_VALUE) continue; // 자기 자신과의 거리는 제외
                    // i에서 j로 가는 경로와 j에서 k로 가는 경로가 있다면, i에서 k로 가는 경로와 비교하여 answer 갱신
//                    if (result[i][j] != Integer.MAX_VALUE && result[j][k] != Integer.MAX_VALUE) {
//                        int sum = result[i][j] + result[j][k];
//                        if (answer > sum) answer = sum;
//                    }
                	if (i == j) continue;
                	if (result[i][j] > result[i][k] + result[k][j]) result[i][j] = result[i][k] + result[k][j]; 
                }
            }
        }
        
        int answer = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
 
                // 자기 자신을 제외한 두 정점이
                // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
                if (result[i][j] != INF && result[j][i] != INF) {
                    answer = Math.min(answer, result[i][j] + result[j][i]);
                }
            }
        }
        
        if (answer == INF) System.out.println(-1); // 사이클이 없을 경우
		else System.out.println(answer); // 사이클이 있을 경우 가장 작은 값을 출력

	}
}