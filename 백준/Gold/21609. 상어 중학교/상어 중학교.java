import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static class Group implements Comparable<Group> {
        int size;
        int rainbowBlocks;
        int standardX;
        int standardY;
        int block;

        public Group(int size, int rainbowBlocks, int standardX, int standardY, int block) {
            this.size = size;
            this.rainbowBlocks = rainbowBlocks;
            this.standardX = standardX;
            this.standardY = standardY;
            this.block = block;
        }

        @Override
        public int compareTo(Group o) {
            if (o.size == size) {
                if (o.rainbowBlocks == rainbowBlocks) {
                    if (o.standardX == standardX) return o.standardY - standardY;
                    return o.standardX - standardX;
                }
                return o.rainbowBlocks - rainbowBlocks;
            }
            return o.size - size;
        }
    }
    static PriorityQueue<Group> pq, pq2;
    static Queue<int[]> q;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < N; i++) System.out.println(Arrays.toString(map[i]));


        while (true) {

            // 1. 크기가 가장 큰 블록 그룹 찾기
            // 그룹이 여러 개라면,
            // (1) 포함된 무지개 블록 수가 가장 많은 블록 그룹
            // (2) 기준 블록의 행이 가장 큰 그룹
            // (3) 기준 블록의 열이 가장 큰 그룹
            findMaxBlockGroup();
//            for (int j = 0; j < N; j++) System.out.println(Arrays.toString(map[j]));
            if (!canPlay()) break;
            // 2. 1에서 찾은 블록 그룹의 모든 블록을 제거 후, 블록 그룹에 포함된 블록의 수의 제곱만큼 점수 획득.
            removeMaxBlockGroup();
//            for (int j = 0; j < N; j++) System.out.println(Arrays.toString(map[j]));
//            if (!canPlay()) break;
            // 3. 중력
            gravity();
            // 4. 반시계 회전
            counterClockwise();
            // 5. 중력
            gravity();
//            System.out.println(total);
        }
        System.out.println(total);
    }
    public static boolean canPlay() {
        pq2 = new PriorityQueue<>();
        boolean flag = false;
        while(!pq.isEmpty()) {
            Group group = pq.poll();
            if (group.size > 1) {
                flag = true;
            }
            pq2.add(group);
        }
        while(!pq2.isEmpty()) {
            Group group = pq2.poll();
            pq.add(group);
        }
        return flag;
    }
    public static void removeMaxBlockGroup() {
        Group group = pq.poll();
        total += Math.pow(group.size, 2);
        visit = new boolean[N][N];
        int x = group.standardX;
        int y = group.standardY;
        visit[x][y] = true;
        map[x][y] = -2;
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 무지개 블록이고 방문하지 않았을 때
                if (map[nx][ny] == 0 && !visit[nx][ny]) {
                    map[nx][ny] = -2;
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    // 같은 블록이고 방문하지 않았을 때
                } else if (map[nx][ny] == group.block && !visit[nx][ny]) {
                    map[nx][ny] = -2;
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    public static void findMaxBlockGroup() {
        pq = new PriorityQueue<>();
        q = new LinkedList<>();
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 무지개 블록 싹 다 false로 바꿔주는 로직 필요함
                if (map[i][j] > 0 && !visit[i][j]) {
                    int mine = map[i][j];
                    visit[i][j] = true;
                    q.add(new int[]{i, j});
                    int cnt = 1;
                    int rainbowBlocks = 0;
                    int standX = i;
                    int standY = j;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int cx = cur[0];
                        int cy = cur[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            // 무지개 블록이고 방문하지 않았을 때
                            if (map[nx][ny] == 0 && !visit[nx][ny]) {
                                cnt++;
                                rainbowBlocks++;
                                visit[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            // 같은 블록이고 방문하지 않았을 때
                            } else if (map[nx][ny] == mine && !visit[nx][ny]) {
                                if (nx < standX) {
                                    if (ny < standY) standY = ny;
                                    standX = nx;
                                }
                                cnt++;
                                visit[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                    pq.add(new Group(cnt, rainbowBlocks, standX, standY, mine));
                    changeVisitStatus();
                }
            }
        }
    }
    public static void changeVisitStatus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) visit[i][j] = false;
            }
        }
    }

    public static void counterClockwise() {
        int[][] tempMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[N-1-j][i] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = tempMap[i][j];
            }
        }
    }

    public static void gravity() {
        // 1열부터 차례대로
        for (int j = 0; j < N; j++) {
            // N - 1행부터 차례대로
            for (int i = N - 1; i >= 0; i--) {
                if (i == N - 1 || map[i][j] == -1 || map[i][j] == -2) continue;
                int findBlank = -1;
                for (int k = i + 1; k < N; k++) {
                    if (map[k][j] == -1) break;
                    if (map[k][j] == -2) findBlank = k;
                }
                if (findBlank != -1) {
                    map[findBlank][j] = map[i][j];
                    map[i][j] = -2;
                }
            }
        }
    }
}