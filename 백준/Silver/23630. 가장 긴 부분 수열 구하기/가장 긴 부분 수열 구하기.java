import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 1. & 연산의 경우 두 비트가 모두 1일때만 1, 아닐때는 0으로 설정한다는 점을 이용
// 2. 따라서, 우선 비트의 개수를 저장해 둘 배열을 만들어 둔다. ex) arr[0] : 0번째 자리에서 비트 1의 개수, ..
// 3. 각각의 수를 모두 2진수로 바꾼 다음 각 자리를 검사하면서 비트가 1인 경우, 배열의 해당 자리 값을 1 증가시킨다.
// 4. &연산의 결과가 0이 되지 않으려면, 연산을 하는 값들의 비트중 하나라도 모두 1이 나와야 한다. 따라서 1이 가장 많이 나온 자리를 찾아주어야 하므로, 배열의 최댓값을 구한다.

//       16 8 4 2 1
// 5  =>  0 0 1 0 1
// 6  =>  0 0 1 1 0
// 7  =>  0 0 1 1 1
// 11 =>  0 1 0 1 1
// 15 =>  0 1 1 1 1
//     ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//        0 2 4 4 4
// max 값은 4
public class Main { 
	static int N, ans;
	static int[] arr, bitCount;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2진수 배열 선언
		bitCount = new int[32];
		
		for (int i = 0; i < N; i++) {
			int temp = arr[i];
			int j = 0;
			while (temp > 0) {
				bitCount[j] += (temp % 2);
				temp = temp / 2;
				j++;
			}
		}
		
		int maxBitCount = 0;
		
		for (int i = 0; i < 32; i++) {
			if (bitCount[i] > maxBitCount) maxBitCount = bitCount[i];
		}
		System.out.println(maxBitCount);
	}
}