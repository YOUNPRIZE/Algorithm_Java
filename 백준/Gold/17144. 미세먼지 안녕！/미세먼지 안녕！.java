import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x, y, conc;
        public Node(int x, int y, int conc) {
            this.x = x;
            this.y = y;
            this.conc = conc;
        }
    }
    static int R,C,T,downM;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q, qUp, qDown;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new int[R][C];
        q = new LinkedList<>();
        qUp = new LinkedList<>();
        qDown = new LinkedList<>();
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) downM = i;
                if (graph[i][j] > 0) q.add(new Node(i,j,graph[i][j]));
            }
        }
        
        for (int k = 0; k < T; k++) {
            // 일단 바이러스를 퍼뜨리고
            spread();
//            for (int i = 0; i < R; i++) System.out.println(Arrays.toString(graph[i]));
//            System.out.println();
//            System.out.println(downM);
            // 공기청정기의 바람 순환 및 미세먼지 제거
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    // 그래프에서 위부분
                    if (i < downM) {
                        if (i == downM - 1 || i == 0 || j == C - 1 || j == 0) {
                            if (graph[i][j] > 0) qUp.add(new Node(i, j, graph[i][j]));
                        }
                    // 그래프에서 아래부분
                    } else {
                        if (i == downM || i == R - 1 || j == C - 1 || j == 0) {
                            if (graph[i][j] > 0) qDown.add(new Node(i, j, graph[i][j]));
                        }
                    }
                }
            }
            moveUp();
            moveDown();
//            for (int i = 0; i < R; i++) System.out.println(Arrays.toString(graph[i]));
//            System.out.println();
            
            // 잔여 미세먼지 다시 큐에 넣기
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (graph[i][j] > 0) q.add(new Node(i,j,graph[i][j]));
                }
            }
//            int cnt = 0;
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    if (graph[i][j] > 0) cnt += graph[i][j];
//                }
//            }
//            System.out.println(cnt);
        }
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] > 0) cnt += graph[i][j];
            }
        }
        System.out.println(cnt);
    }
    public static void moveDown() {
        while(!qDown.isEmpty()) {
            Node node = qDown.poll();
            int x = node.x;
            int y = node.y;
            int val = node.conc;
            // 오른쪽으로 이동
            if (x == downM) {
                if (y == C - 1) {
                    graph[x][y] -= val;
                    graph[x+1][y] += val;
                } else {
                    graph[x][y] -= val;
                    graph[x][y+1] += val;
                }
            // 왼쪽으로 이동
            } else if (x == R-1) {
                if (y == 0) {
                    graph[x][y] -= val;
                    graph[x-1][y] += val;
                } else {
                    graph[x][y] -= val;
                    graph[x][y-1] += val;
                }
            // 위로 이동
            } else if (y == 0) {
                if (x == downM + 1) {
                    graph[x][y] -= val;
                } else {
                    graph[x][y] -= val;
                    graph[x-1][y] += val;
                }
            // 아래로 이동
            } else if (y == C - 1) {
                if (x == R - 1) {
                    graph[x][y] -= val;
                    graph[x][y-1] += val;
                } else {
                    graph[x+1][y] += val;
                    graph[x][y] -= val;
                }
            }
        }
    }
    // 그래프에서 위
    public static void moveUp() {
        while(!qUp.isEmpty()) {
            Node node = qUp.poll();
            int x = node.x;
            int y = node.y;
            int val = node.conc;
            // 오른쪽으로 이동
            if (x == downM - 1) {
                if (y == C - 1) {
                    graph[x][y] -= val;
                    graph[x-1][y] += val;
                } else {
                    graph[x][y] -= val;
                    graph[x][y+1] += val;
                }
            // 왼쪽으로 이동
            } else if (x == 0) {
                if (y == 0) {
                    graph[x][y] -= val;
                    graph[x+1][y] += val;
                } else {
                    graph[x][y] -= val;
                    graph[x][y-1] += val;
                }
            // 위로 이동
            } else if (y == C - 1) {
                if (x == 0) {
                    graph[x][y] -= val;
                    graph[x][y-1] += val;
                } else {
                    graph[x][y] -= val;
                    graph[x-1][y] += val;
                }
            // 아래로 이동
            } else if (y == 0) {
                if (x == downM - 2) {
                    graph[x][y] -= val;
                } else {
                    graph[x+ 1][y] += val;
                    graph[x][y] -= val;
                }
            }
        }
    }
    
    
    // 바이러스 퍼지는 메소드
    public static void spread() {
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int val = node.conc;
//            System.out.println(val);
            
            int div = val/5;
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (graph[nx][ny] == -1) continue;
                count++;
                graph[nx][ny] += div;
            }
            graph[x][y] -= count * div;
        }
    }
}