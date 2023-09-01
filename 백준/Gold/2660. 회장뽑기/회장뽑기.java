import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == -1 && B == -1) break;
            map[A][B] = 1;
            map[B][A] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) map[j][k] = map[j][i] + map[i][k];
//                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int readerScore = INF;

        int[] scoreArr = new int[N + 1]; // 친구 점수 목록

        for (int i = 1; i <= N; i++) {
            int score = 0;
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != Integer.MAX_VALUE) {
                    score = Math.max(score, map[i][j]);
                }
            }

            scoreArr[i] = score;
            readerScore = Math.min(readerScore, score);
        }

        StringBuilder title = new StringBuilder();
        title.append(readerScore + " ");

        int readerNum = 0;

        StringBuilder body = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (readerScore == scoreArr[i]) {
                readerNum++;
                body.append(i + " ");
            }
        }

        title.append(readerNum + "\n");
        System.out.println(title.toString() + body.toString());
//        System.out.println(body.toString());
    }
}