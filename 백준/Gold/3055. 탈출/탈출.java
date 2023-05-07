import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static Character map[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> sq = new LinkedList<int[]>();
    static Queue<int[]> wq = new LinkedList<int[]>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer( br.readLine() );
        R = Integer.parseInt( st.nextToken() );
        C = Integer.parseInt( st.nextToken() );

        map = new Character[R][C];

        for( int i=0; i<R; i++ ) {
            String str = br.readLine();
            for( int j=0; j<C; j++ ) {
                map[i][j] = str.charAt(j);
                if( map[i][j] == 'S' )
                    sq.add( new int[] {i, j, 0} );
                else if( map[i][j] == '*' )
                    wq.add( new int[] {i, j} );
            }
        }

        BFS();

        System.out.println( answer==Integer.MAX_VALUE ? "KAKTUS" : answer );
    }

    public static void BFS() {

        while( !sq.isEmpty() ) {
        	int w_len = wq.size();
            for( int i=0; i<w_len; i++ ) {
                int[] cur_w = wq.poll();

                for( int j=0; j<4; j++ ) {
                    int nx = cur_w[0] + dx[j];
                    int ny = cur_w[1] + dy[j];

                    if( nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]=='.' ) {
                        map[nx][ny] = '*';
                        wq.add( new int[] { nx, ny } );
                    }
                }
            }

            int s_len = sq.size();
            for( int i=0; i<s_len; i++ ) {
                int[] cur_s = sq.poll();

                for( int j=0; j<4; j++ ) {
                    int nx = cur_s[0] + dx[j];
                    int ny = cur_s[1] + dy[j];
                    int time = cur_s[2];

                    if( nx>=0 && nx<R && ny>=0 && ny<C ) {
                        if( map[nx][ny] == 'D' ) {
                            answer = Math.min( answer, time+1 );
                            return;
                        }

                        else if( map[nx][ny] == '.' ) {
                            map[nx][ny] = 'S';
                            sq.add( new int[] { nx, ny, time+1 } );
                        }
                    }
                }
            }
        }
    }
}