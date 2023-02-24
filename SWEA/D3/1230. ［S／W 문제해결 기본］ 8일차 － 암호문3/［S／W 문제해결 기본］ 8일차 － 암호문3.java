
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer> password;
	static int N;
	static int M;
	//static Scanner sc;
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		//sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			System.out.print("#" + tc + " ");
			// 원본 암호문의 길이 N
			//N = sc.nextInt();
			N = Integer.parseInt(br.readLine());
			password = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			// 원본 암호문
			for (int i = 0; i < N; i++) {
				//password.add(sc.nextInt());
				password.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어의 개수 M
			//int M = sc.nextInt();
			M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				//Character order = sc.nextLine().charAt(0);
				//String order = sc.nextLine();
				String order = st.nextToken();
				// I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다.
				// s는 덧붙일 숫자들이다.[ex) I 3 2 123152 487651 ]
				//if (order == 'I') {
				if (order.equals("I")) {
//					int x = sc.nextInt();
					int x = Integer.parseInt(st.nextToken());
//					int y = sc.nextInt();
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						insert(x, k);
					}
			    // D(삭제) x, y : 앞에서부터 x의 위치 바로 다음부터 y개의 숫자를 삭제한다.
				// [ex) D 4 4 ]
				//} else if (order == 'D') {
				} else if (order.equals("D")) {
//					int x = sc.nextInt();
					int x = Integer.parseInt(st.nextToken());
//					int y = sc.nextInt();
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						delete(x);
					}
				// A(추가) y, s : 암호문의 맨 뒤에 y개의 숫자를 덧붙인다. s는 덧붙일 숫자들이다. 
				// [ex) A 2 421257 796813 ]
				//} else {
				} else {
//					int y = sc.nextInt();
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						add();
					}
				}
			}
			for (int i = 0; i < 10; i++) {
				System.out.print(password.get(i) + " ");
			}
			System.out.println();
		}
	}
	// 삽입
	public static void insert(int x, int k) {
		password.add(x+k, Integer.parseInt(st.nextToken()));
	}
	// 삭제
	public static void delete(int x) {
		password.remove(x);
	}
	// 추가
	public static void add() {
		password.add(Integer.parseInt(st.nextToken()));
	}
}
