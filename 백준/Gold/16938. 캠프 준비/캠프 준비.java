import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n,l,r,x,ans;
	static int[] a;
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        
        bitmasking();
        
        System.out.println(ans);
    }
    
    public static void bitmasking() {
    	for (int i = 1; i < (1 << n); i++) {
            if (Integer.bitCount(i) < 2) { // 문제를 2개 이상 풀어야 함
                continue;
            }
            int t = 0;
            int m = 0;
            int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    t += a[j];
                    m |= 1 << j;
                    mn = Math.min(mn, a[j]);
                    mx = Math.max(mx, a[j]);
                }
            }
            if (t >= l && t <= r && mx - mn >= x) {
                ans++;
            }
        }
    }
}