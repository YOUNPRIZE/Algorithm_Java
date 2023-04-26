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
//        System.out.println((1 << n));
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
    		// 1의 개수를 세기 위해 Integer.bitCount() 메소드 사용
            if (Integer.bitCount(i) < 2) { // 문제를 2개 이상 풀어야 함
                continue;
            }
            // 선택한 문제의 난이도의 합
            int t = 0;
            // 선택한 문제를 이진수로 표현한 것을 합친 값
//            int m = 0;
            // 최솟값
            int mn = Integer.MAX_VALUE;
            // 최댓값
            int mx = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    t += a[j];
//                    m |= 1 << j;
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