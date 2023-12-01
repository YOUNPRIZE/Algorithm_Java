import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int P = Integer.parseInt(str[1]);
        int idx = 0;
        int temp = N;
        int[] arr = new int[P + 1];
        boolean isFound = false;
        while (!isFound) {
            temp = N * temp % P;
            for (int i = 0; i < idx; i++) {
                if (arr[i] == temp) {
                    isFound = true;
                    System.out.print(idx - i);
                    break;
                }
            }
            arr[idx] = temp;
            idx++;
        }
    }
}