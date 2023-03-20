import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder[] arr = new StringBuilder[202];
		for (int i = 0; i < N; i++) {
			String[] ageName = br.readLine().split(" ");
//			System.out.println(ageName[0]);
			if (arr[Integer.parseInt(ageName[0])] == null) {
				StringBuilder sb = new StringBuilder();
				sb.append(ageName[1]).append(" ");
				arr[Integer.parseInt(ageName[0])] = sb;
			} else {
				arr[Integer.parseInt(ageName[0])] = arr[Integer.parseInt(ageName[0])].append(ageName[1]).append(" ");
			}
		    
		}
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
//				System.out.println(i);
//				System.out.println(arr[i]);
				String[] str = arr[i].toString().split(" ");
				for (int j = 0; j < str.length; j++) {
					System.out.print(i + " ");
					System.out.println(str[j]);
				}
			}
		}		
	}
}