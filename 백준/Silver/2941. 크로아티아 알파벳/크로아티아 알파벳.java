import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int cnt = 0;
		if (str.contains("c=")) {
			cnt += (str.length() - str.replace("c=", "").length()) / 2;
			//str = str.replace("c=", "");
		}
		if (str.contains("c-")) {
			cnt += (str.length() - str.replace("c-", "").length()) / 2;
			//str = str.replace("c-", "");
		}
		if (str.contains("dz=")) {
			cnt += (str.length() - str.replace("dz=", "").length()) / 3;
			//str = str.replace("dz=", "");
		}
		if (str.contains("d-")) {
			cnt += (str.length() - str.replace("d-", "").length()) / 2;
			//str = str.replace("d-", "");
		}
		if (str.contains("lj")) {
			cnt += (str.length() - str.replace("lj", "").length()) / 2;
			//str = str.replace("lj", "");
		}
		if (str.contains("nj")) {
			cnt += (str.length() - str.replace("nj", "").length()) / 2;
			//str = str.replace("nj", "");
		}
		if (str.contains("s=")) {
			cnt += (str.length() - str.replace("s=", "").length()) / 2;
			//str = str.replace("s=", "");
		}
		if (str.contains("z=")) {
			cnt += (str.length() - str.replace("z=", "").length()) / 2;
			//str = str.replace("z=", "");
		}
		//System.out.println(s);
		//cnt += str.length();
		System.out.println(str.length() - cnt);
	}
}
