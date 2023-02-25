import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        
        int[][] snail = new int[n][n];
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int cr = 0;
        int cc = 0;
        int d = 0;
        
        for(int num = n * n; num >= 1; num--) {
            snail[cr][cc] = num;
            int nr = dr[d] + cr;
            int nc = dc[d] + cc;
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || snail[nr][nc] != 0) {
                d = (d + 1) % 4;
            }
            cr += dr[d];
            cc += dc[d];
        }
        
        StringBuilder sb = new StringBuilder();
        
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
//                System.out.print(snail[i][j] + " ");
                sb.append(snail[i][j]).append(" ");
                if (snail[i][j] == f) {
                	x = i+1;
                	y = j+1;
                }
            }
//            System.out.println();
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(x + " " + y);
    }
}