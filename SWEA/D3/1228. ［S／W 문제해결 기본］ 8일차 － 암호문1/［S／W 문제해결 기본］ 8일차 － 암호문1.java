import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> list = new LinkedList<>();
			System.out.printf("#%d ", tc);
			
			// 원본 암호문의 길이 N
			int N = sc.nextInt();
			
			// 원본 암호문
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			// 명령어의 개수
			int M = sc.nextInt();
			
			for (int i = 0; i < M; i++) {
				String order = sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				for (int j = 0; j < y; j++) {
					list.add(x+j, sc.nextInt());
				}
			}
			
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ", list.get(i));
			}
			System.out.println();
		}
	}
}