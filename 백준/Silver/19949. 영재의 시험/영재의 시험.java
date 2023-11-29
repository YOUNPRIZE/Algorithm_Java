import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] correct = new int[10];
    static int[] answer = new int[10];
    static int totalCase = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) correct[i] = Integer.parseInt(st.nextToken());
        dfs(0);
        System.out.println(totalCase);
    }

    public static void dfs(int depth) {
        // base case
        if (depth == 10) {
            grade();
            return;
        }

        // recursive case
        for (int i = 1; i <= 5; i++) {
            answer[depth] = i;
            if (depth >= 2) {
                if (answer[depth - 2] == answer[depth - 1] && answer[depth - 1] == answer[depth]) continue;
            }
            dfs(depth + 1);
        }
    }

    // 3연속 같은 답인지?
    public static boolean isTriple() {
        for (int i = 2; i < 10; i++) {
            if (answer[i - 2] == answer[i - 1] && answer[i - 1] == answer[i]) return true;
        }
        return false;
    }

    // 5점 이상일 때 count
    public static void grade() {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            if (correct[i] == answer[i]) result++;
            if (result >= 5) {
                totalCase++;
                return;
            }
        }
    }
}