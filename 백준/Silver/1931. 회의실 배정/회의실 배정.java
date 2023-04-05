import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class MR implements Comparable<MR> {
		int start;
		int end;
		public MR(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(MR o) {
			if (end == o.end) {
				return start - o.end;
			}
			return end - o.end;
		}
	}
	static int N;
	static List<MR> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new MR(start, end));
		}
		
		Collections.sort(list);
//		for (MR mr : list) {
//			System.out.println(mr.start);
//			System.out.println(mr.end);
//			System.out.println();
//		}
		
		int cnt = 0;
		int end = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				cnt++;
				end = list.get(i).end;
			} else if (list.get(i).start >= end) {
				cnt++;
				end = list.get(i).end;
			}
		}
		System.out.println(cnt);
	}
}