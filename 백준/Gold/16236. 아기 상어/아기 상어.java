import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Fish {
        int x;
        int y;
        int dist;
        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N;
    static int[][] graph;
    static Queue<Fish> q;
    static int sharkSize = 2;
    static int time = 0;
    static int eat = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        q = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 9) {
                    q.add(new Fish(i, j, 0));
                    graph[i][j] = 0;
                }
            }
        }

        while (true) {
            ArrayList<Fish> eatFish = new ArrayList<>();
            int[][] dist = new int[N][N];

            while (!q.isEmpty()) {
                Fish shark = q.poll();
                int x = shark.x;
                int y = shark.y;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (dist[nx][ny] == 0 && graph[nx][ny] <= sharkSize) {
                            dist[nx][ny] = dist[x][y] + 1;
                            q.add(new Fish(nx, ny, dist[nx][ny]));
                            if (1 <= graph[nx][ny] && graph[nx][ny] < sharkSize) {
                                eatFish.add(new Fish(nx, ny, dist[nx][ny]));
                            }
                        }
                    }
                }
            } 


            if (eatFish.size() == 0) {
                System.out.println(time);
                return;
            }

            Fish fish = eatFish.get(0);
            for (int i = 1; i < eatFish.size(); i++) {
                // 거리가 더 가까운 물고기이면
                if (fish.dist > eatFish.get(i).dist) {
                    fish = eatFish.get(i);
                // 거리가 같은 물고기이면
                } else if (fish.dist == eatFish.get(i).dist) {
                    // 위에 있는 물고기
                    if (fish.x > eatFish.get(i).x) {
                        fish = eatFish.get(i);
                    } else if (fish.x == eatFish.get(i).x) {
                        // 왼쪽에 있는 물고기
                        if (fish.y > eatFish.get(i).y) {
                            fish = eatFish.get(i);
                        }
                    }
                }
            }
            graph[fish.x][fish.y] = 0;
            time += fish.dist;
            eat++;
            if (sharkSize == eat) {
                sharkSize++;
                eat = 0;
            }
            q.add(fish);
        }
    }
 }