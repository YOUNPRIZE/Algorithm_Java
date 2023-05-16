import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for	(int i = 0; i < 3; i++) {
			 
			 int cnt = 0;
			 String[] str = br.readLine().split(" ");
			 for (int j = 0; j < 4; j++) {
				 int N = Integer.parseInt(str[j]);
				 cnt += N;
			 }
			 switch (cnt) {
			 case 3:
				 System.out.println("A");
				 break;
			 case 2:
				 System.out.println("B");
				 break;
			 case 1:
				 System.out.println("C");
				 break;
			 case 0:
				 System.out.println("D");
				 break;
			 case 4:
				 System.out.println("E");
				 break;
			 }
		}
	}
}