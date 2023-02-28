import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static List<List<Integer>> list;
	static int[] arr;
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(new ArrayList<>());
				list.get(i).add(sc.nextInt());
				list.get(i).add(sc.nextInt());
			}
			int P = sc.nextInt();
			
			arr = new int[P];
			cnt = new int[P+1];
			
			for (int i = 0; i < P; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println(list);
//			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				int idx = 1;
				for (int j : arr) {
					if (j >= list.get(i).get(0) && j <= list.get(i).get(1)) {
						cnt[idx++]++;
					} else {
						idx++;
					}
					//System.out.println(Arrays.toString(cnt));
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 1; i <= P; i++ ) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}
	}
}