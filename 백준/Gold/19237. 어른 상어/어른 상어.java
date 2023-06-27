import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static class Shark {
        int x;
        int y;
        int dir;
        public Shark (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    static int N, M, K;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    // 냄새가 없어질 때까지 남은 시간
    static int[][] rest;
    // 냄새를 뿌린 상어의 번호
    static int[][] smell;
    // 상어의 우선순위 방향
    static int[][][] priorDir;
    // 상어의 정보를 담을 배열
    static Shark[] shark;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N * N 격자의 크기
        N = Integer.parseInt(st.nextToken());
        // 상어의 마리수
        M = Integer.parseInt(st.nextToken());
        // 냄새가 사라지는 시간
        K = Integer.parseInt(st.nextToken());

        rest = new int[N+1][N+1];
        smell = new int[N+1][N+1];
        priorDir = new int[M+1][5][4];
        shark = new Shark[M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    shark[num] = new Shark(i, j, 0);
                    // 해당 칸에 냄새가 사라지는 시간 초기화
                    rest[i][j] = K;
                    // 냄새를 어떤 상어가 남겼는지 초기화
                    smell[i][j] = num;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            shark[i].dir = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    priorDir[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(solution());
    }
    public static int solution() {
        int time = 0;
        while(true) {
            int count = 0;

            for (int i = 1; i <= M; i++) {
                if (shark[i] != null) count++;
            }

            // 1번 상어만 남았을 경우
            if (count == 1 && shark[1] != null) return time;

            // 1000번 이상일 경우
            if (time >= 1000) return -1;

            int[][] temp = new int[N+1][N+1];

            for (int i = 1; i <= M; i++) {
                // 해당 번호의 상어가 있다면
                if (shark[i] != null) {
                    moveShark(temp, i);
                }
            }

            // 냄새 기간 줄이기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (rest[i][j] > 0) rest[i][j]--;
                    if (rest[i][j] == 0) smell[i][j] = 0;
                }
            }

            // 이동 후의 상어 위치의 냄새 정보와 시간 초기화하기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (temp[i][j] > 0) {
                        rest[i][j] = K;
                        smell[i][j] = temp[i][j];
                    }
                }
            }
            time++;
        }
    }
    public static void moveShark(int[][] temp, int num) {
        int nx = 0;
        int ny = 0;
        int dir = 0;

        boolean check = false;

        // 높은 우선순위부터 차례대로 탐색
        for (int i = 0; i < 4; i++) {
            dir = priorDir[num][shark[num].dir][i];
            nx = shark[num].x + dx[dir];
            ny = shark[num].y + dy[dir];

            if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

            if (smell[nx][ny] == 0) {
                check = true;
                break;
            }
        }

        // 위의 반복문에서 아무곳도 못갔을 경우
        if (!check) {
            for (int i = 0; i < 4; i++) {
                dir = priorDir[num][shark[num].dir][i];
                nx = shark[num].x + dx[dir];
                ny = shark[num].y + dy[dir];

                if (nx < 1 || nx > N || ny < 1 || ny > N) continue;

                if (smell[nx][ny] == num) {
                    break;
                }
            }
        }

        if (temp[nx][ny] == 0) {
            temp[nx][ny] = num;
            shark[num].x = nx;
            shark[num].y = ny;
            shark[num].dir = dir;
        }

        else shark[num] = null;
    }
}