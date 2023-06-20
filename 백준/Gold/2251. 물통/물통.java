import java.util.*;

class State {
    int[] x;

    public State(int[] x) {
        this.x = x;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = sc.nextInt();
        }
        boolean[][][] visited = new boolean[201][201][201]; // 물통 용량 범위

        List<Integer> answer = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(new int[]{0, 0, limit[2]}));
        visited[0][0][limit[2]] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int[] curX = cur.x;

            if (curX[0] == 0) {
                answer.add(curX[2]);
            }

            // 물 옮기기
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    int[] nextX = Arrays.copyOf(curX, 3);
                    if (curX[from] + curX[to] > limit[to]) { // 옮기는 물의 양이 넘칠 경우
                        nextX[from] -= (limit[to] - curX[to]);
                        nextX[to] = limit[to];
                    } else { // 옮기는 물의 양이 넘치지 않을 경우
                        nextX[to] += nextX[from];
                        nextX[from] = 0;
                    }

                    if (!visited[nextX[0]][nextX[1]][nextX[2]]) {
                        visited[nextX[0]][nextX[1]][nextX[2]] = true;
                        queue.offer(new State(nextX));
                    }
                }
            }
        }

        Collections.sort(answer);
        for (int value : answer) {
            System.out.print(value + " ");
        }
    }
}