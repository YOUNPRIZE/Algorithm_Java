
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		for (int tc = 1; tc <= N; tc++) {
			//String numA = br.readLine().replace(" ", "");
			
			StringBuilder sb1 = new StringBuilder();
			sb1.append(br.readLine().replace(" ", ""));
			sb1.deleteCharAt(0);
			
			String numA = sb1.toString();
			
			StringBuilder sb2 = new StringBuilder();
			sb2.append(br.readLine().replace(" ", ""));
			sb2.deleteCharAt(0);
			
			String numB = sb2.toString();
			
			int starA = numA.length() - numA.replace("4", "").length();
			int starB = numB.length() - numB.replace("4", "").length();
			
			int circleA = numA.length() - numA.replace("3", "").length();
			int circleB = numB.length() - numB.replace("3", "").length();
			
			int squareA = numA.length() - numA.replace("2", "").length();
			int squareB = numB.length() - numB.replace("2", "").length();
			
			int triA = numA.length() - numA.replace("1", "").length();
			int triB = numB.length() - numB.replace("1", "").length();
			// 별은 4 동그라미는 3 네모는 2 세모는 1
			if (starA != starB) {
				if (starA > starB) System.out.println("A");
				else System.out.println("B");
			} else if (starA == starB && circleA != circleB) {
				if (circleA > circleB) System.out.println("A");
				else System.out.println("B");
			} else if (starA == starB && circleA == circleB && squareA != squareB) {
				if (squareA > squareB) System.out.println("A");
				else System.out.println("B");
			} else if (starA == starB && circleA == circleB && squareA == squareB && triA != triB) {
				if (triA > triB) System.out.println("A");
				else System.out.println("B");
			} else {
				System.out.println("D");
			}
		}
	}
}
