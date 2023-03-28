import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BAEK17141. 연구소
public class Main {
    static int[][] graph, temp;
    static int N, M, min;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    static Queue<int[]> q;
    static boolean check;
    static List<int[]> list;
    static boolean[] visitVirus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                	list.add(new int[] {i,j});
                	graph[i][j] = 0;
                } else if (graph[i][j] == 1) {
                	graph[i][j] = -1;
                }
            }
        }
        visitVirus = new boolean[list.size()];
        min = Integer.MAX_VALUE;
        dfs(0, 0);
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
        
    }
    public static void bfs() {
        temp = new int[N][N];
        q = new LinkedList<>();
        //boolean[][] visit = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
        	temp[i] = graph[i].clone();
        }
        
        for (int i = 0; i < list.size(); i++) {
        	if (visitVirus[i]) {
        		temp[list.get(i)[0]][list.get(i)[1]] = 1;
        		q.add(new int[] {list.get(i)[0], list.get(i)[1]});
        	}
        }
        
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (graph[i][j] == -1) {
//                    temp[i][j] = 1;
//                    visit[i][j] = true;
//                    q.add(new int[] {i, j});
//                }
//                else if (graph[i][j] == 1) temp[i][j] = -1;
//            }
//        }
//        for (int i = 0; i < N; i++) {
//        	System.out.println(Arrays.toString(temp[i]));
//        }
//        System.out.println();
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()) {
            int[] ele = q.poll();
            max = Math.max(max, temp[ele[0]][ele[1]] - 1);
//            if (max == 5) {
//            	System.out.println("Asdfasdf");
//            }
            if (max >= min) return;
//            if (temp[ele[0]][ele[1]] + 1 >= min) return;
            for (int i = 0; i < 4; i++) {
                int nx = ele[0] + dx[i];
                int ny = ele[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                //if (visit[nx][ny]) continue;
                if (temp[nx][ny] == 0) {
                	//visit[nx][ny] = true;
                	temp[nx][ny] = temp[ele[0]][ele[1]] + 1;
                	q.add(new int[] {nx, ny});
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//        	System.out.println(Arrays.toString(temp[i]));
//        }
//        System.out.println();
//        int max = Integer.MIN_VALUE;
//        boolean flag = false;
        
       for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                max = Math.max(max, temp[i][j]);
                if (temp[i][j] == 0) {
                    return;
//                	flag = true;
//                    break;
                }
            }
//            if (flag) break;
        }
        min = Math.min(min, max);
//        if (min == 5) {
//        	System.out.println("asdfasdf");
//        }
    }
    
    public static void dfs(int start, int count) {
        // base case
        if (count == M) {
            bfs();
            return;
        }
        // recursive case
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (graph[i][j] == 2) {
//                    graph[i][j] = -1;
//                    dfs(virus + 1);
//                    graph[i][j] = 2;
//                }
//            }
//        }
        for (int i = start; i < list.size(); i++) {
        	if (!visitVirus[i]) {
        		visitVirus[i] = true;
        		dfs(start + 1, count + 1);
        		visitVirus[i] = false;
        	}
        }
    }
}