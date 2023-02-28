import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static String[] arr;
	static List<List<Integer>> list;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			list = new ArrayList<>();
			N = Integer.parseInt(sc.nextLine());
			arr = new String[N+1];
			for (int i = 0; i < N; i++) {
				String[] strArr = sc.nextLine().split(" ");
				//System.out.println(Arrays.toString(strArr));
				arr[Integer.parseInt(strArr[0])] = strArr[1];
				list.add(new ArrayList<>());
				if (strArr.length > 2) {
					for (int j = 2; j < strArr.length; j++) {
						list.get(i).add(Integer.parseInt(strArr[j]));
					}
				}
			}
			//System.out.println(list);
			System.out.printf("#%d ", tc);
			traverse(1);
			System.out.println();
		}
	}
	
	public static void traverse(int i) {
		if (i <= N) {
			// 왼쪽
			if (list.get(i-1).size() > 0) {
				int left = list.get(i-1).get(0);
				traverse(left);
			}
			// 자기 자신
			System.out.print(arr[i]);
			// 오른쪽
			if (list.get(i-1).size() > 1) {
				int right = list.get(i-1).get(1);
				traverse(right);
			}
		}
	}
}