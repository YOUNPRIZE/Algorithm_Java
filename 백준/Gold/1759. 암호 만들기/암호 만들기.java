import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int L,C, vowel, nonvowel;
	static String[] arr, arrComb, arrPerm;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] LC = br.readLine().split(" ");
		L = Integer.parseInt(LC[0]);
		C = Integer.parseInt(LC[1]);
		arr = new String[C];
		arrComb = new String[L];
		String[] strArr = br.readLine().split(" ");
		for (int i = 0; i < C; i++) {
			arr[i] = strArr[i];
		}
		sb = new StringBuilder();
		Arrays.sort(arr);
		
		Comb(0, 0);
		System.out.println(sb.toString());
	}
	
	public static void Comb(int idx, int sidx) {
		if (sidx == L) {
			//System.out.println(Arrays.toString(arrComb));
			vowel = 0;
			nonvowel = 0;
			for (String str : arrComb) {
				switch (str) {
				case("a"):
					vowel++;
					break;
				case("e"):
					vowel++;
					break;
				case("i"):
					vowel++;
					break;
				case("o"):
					vowel++;
					break;
				case("u"):
					vowel++;
					break;
				default:
					nonvowel++;
					break;
				}
			}
			if (vowel >= 1 && nonvowel >= 2) {
				for (String i : arrComb) {
					sb.append(i);
				}
				sb.append("\n");
			}
			return;
		}
		
		if (idx == C) return;
		
		arrComb[sidx] = arr[idx];
		Comb(idx + 1, sidx + 1);
		Comb(idx + 1, sidx);
	}
}