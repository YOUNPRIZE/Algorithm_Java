import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
	static int[][] map, visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> q1;
	static Queue<int[]> q2;
	static int w, h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 열
			w = Integer.parseInt(st.nextToken());
			// 행
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visit = new int[h][w];
			
			// 상근이의 시작 위치
			q1 = new LinkedList<>();
			// 불
			q2 = new LinkedList<>();
			
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					char temp = str.charAt(j);
					// 벽
					if(temp=='#'){
	                    map[i][j] = -1;
	                }
					// 상근이의 시작 위치
	                else if (temp=='@'){
	                    map[i][j] = 1;
	                    q1.add(new int[] {i, j});
	                }
					// 불
	                else if(temp == '*'){
	                    map[i][j] = -2;
	                    q2.add(new int[] {i, j});
	                }
					// 빈 공간
	                else{
	                    map[i][j] = 0;
	                }
				}
			}
			bfs();
		}
	}
	
	public static void bfs() {
		int answer = 0;
		while(true) {
			answer++;
			// 불
			int size1 = q2.size();
			while (size1 > 0) {
				size1--;
				int[] element = q2.poll();
				for (int i = 0; i < 4; i++) {
					int x = element[0] + dx[i];
					int y = element[1] + dy[i];
					if (x < 0 || y < 0 || x >= h || y >= w) continue;
					if (map[x][y] >= 0) {
						q2.add(new int[] {x, y});
						map[x][y] = -2;
					}
				}
			}
			int size2 = q1.size();
			while(size2 > 0) {
				size2--;
				int[] element = q1.poll();
				for (int i = 0; i < 4; i++) {
					int x = element[0] + dx[i];
					int y = element[1] + dy[i];
					if (x < 0 || y < 0 || x >= h || y >= w) {
						System.out.println(answer);
						return;
					};
					if (map[x][y] == 0) {
						q1.add(new int[] {x, y});
						map[x][y] = 1;
					}
				}
			}
			if(q1.isEmpty()){
              System.out.println("IMPOSSIBLE");
              return;
          }
		}
	}
//        int answer = 0;
//        while(true){
//            answer++;
//            int fs  = fq.size();
//            while(fs>0){
//                fs--;
//                Node4179 node = fq.poll();
//                int y = node.y;
//                int x = node.x;
//                for(int i=0; i<4; i++){
//                    if (x+dx[i] >= 0 && x+dx[i] < c && y+dy[i]> 0 && y+dy[i] < r){
//                        if(map[y+dy[i]][x+dx[i]] >=0){
//                            fq.add(new Node4179(y+dy[i], x+dx[i]));
//                            map[y+dy[i]][x+dx[i]] = -2;
//                        }
//                    }
//                }
//            }
//            int js = jq.size();
//            while(js>0){
//                js--;
//                Node4179 node = jq.poll();
//                int y = node.y;
//                int x = node.x;
//                for(int i=0; i<4; i++){
//                    if (x+dx[i] < 0 || x+dx[i] >= c || y+dy[i]< 0 || y+dy[i] >= r){
//                        System.out.println(answer);
//                        return;
//                    }
//                    if(map[y+dy[i]][x+dx[i]] ==0){
//                        jq.add(new Node4179(y+dy[i], x+dx[i]));
//                        map[y+dy[i]][x+dx[i]] = 1;
//                    }
//                }
//            }
//            if(jq.isEmpty()){
//                System.out.println("IMPOSSIBLE");
//                return;
//            }
//        }
//    }
//}
}