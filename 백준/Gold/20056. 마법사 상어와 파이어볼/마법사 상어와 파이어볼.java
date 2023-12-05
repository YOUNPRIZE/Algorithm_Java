import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Fireball {
        int m, d, s;

        public Fireball(int m, int d, int s) {
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
    static int N,M,K;
    static List<Fireball>[][] map, tempMap;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[r][c].add(new Fireball(m,d,s));
        }

        for (int k = 0; k < K; k++) {
            // 1. 모든 파이어볼 이동
            moveFireball();

            // 2. 같은 칸에 있는 파이어볼 합친다 (2개 이상 있는 칸만)
            combineFireball();
        }
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].size() > 0) {
                    for (int k = 0; k < map[i][j].size(); k++) {
                        Fireball fireball = map[i][j].get(k);
                        res += fireball.m;
                    }
                }
            }
        }
        System.out.println(res);
    }
    public static void combineFireball() {
        map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (tempMap[i][j].size() >= 2) {
                    int sumM = 0;
                    int sumS = 0;
                    boolean odd = false;
                    boolean even = false;
                    for (int k = 0 ; k < tempMap[i][j].size(); k++) {
                        Fireball fireball = tempMap[i][j].get(k);
                        sumM += fireball.m;
                        sumS += fireball.s;
                        if (fireball.d % 2 == 0) even = true;
                        else odd = true;
                    }
                    int newD = 0;
                    // 방향 1, 3, 5, 7
                    if (odd && even) newD = 1;
                    int newM = sumM / 5;
                    int newS = sumS / tempMap[i][j].size();
                    if (newM == 0) continue;

                    for (int k = 0; k < 4; k++) {
                        map[i][j].add(new Fireball(newM, newD, newS));
                        newD += 2;
                    }
                } else if (tempMap[i][j].size() == 1) {
                    Fireball fireball = tempMap[i][j].get(0);
                    map[i][j].add(fireball);
                }
            }
        }
    }


    public static void moveFireball() {
        tempMap = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tempMap[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].size() > 0) {
                    for (int k = 0; k < map[i][j].size(); k++) {
                        Fireball fireball = map[i][j].get(k);
                        int nx = i + fireball.s * dx[fireball.d];
                        int ny = j + fireball.s * dy[fireball.d];
                        if (nx > N) {
                            nx = nx % N;
                            if (nx == 0) nx = N;
                        }
                        else if (nx < 1) nx = N - Math.abs(nx) % N;

                        if (ny > N) {
                            ny = ny % N;
                            if (ny == 0) ny = N;
                        }
                        else if (ny < 1) ny = N - Math.abs(ny) % N;

                        tempMap[nx][ny].add(fireball);
                    }
                }
            }
        }
    }
}