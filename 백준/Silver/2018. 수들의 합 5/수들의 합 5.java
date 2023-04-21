import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int ep = 0;
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			// 1,2,3,4,5 더해주는 과정
			while (sum < N && ep <= N) {
				sum += ep;
				ep++;
			}
			
			// while문 탈출하고 sum이 15가 맞으니까 cnt++
			if (sum == N) cnt++;
			
			// start point 인 1(i)를 빼준다.
			// 다음 과정은 2,3,4,5에 6을 더해준다.
			// 2 3 4 5 6
			// 3 4 5 6
			// 4 5 6
			// ...
			sum -= i;
		}
		System.out.println(cnt);
	}
}