import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int blue = 0;
	public static int white = 0;
	public static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Square(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void Square(int row, int col, int size) {
		if(Check(row,col,size)) {
			if (arr[row][col] == 0) white++;
			else blue++;
			return;
		}
		
		int newSize = size / 2;
		
		Square(row, col, newSize);
		Square(row, col+newSize, newSize);
		Square(row+newSize, col, newSize);
		Square(row+newSize, col+newSize, newSize);
	}
	
	public static boolean Check(int row, int col, int size) {
		
		int num = arr[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != num) return false;
			}
		}
		return true;
	} 
}
