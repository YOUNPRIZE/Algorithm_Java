import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int total = 0;
		String[] arr = str.split("-");
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				String[] newArr = arr[i].split("\\+");
				int temp = 0;
				for (String s : newArr) {
					temp += Integer.parseInt(s);
				}
				total += temp;
			} else {
				String[] newArr = arr[i].split("\\+");
				int temp = 0;
				for (String s : newArr) {
					temp += Integer.parseInt(s);
				}
				total -= temp;
			}
		}
		System.out.println(total);
	}
}