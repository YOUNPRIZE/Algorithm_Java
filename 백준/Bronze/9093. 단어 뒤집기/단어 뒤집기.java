import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();
//        int N = sc.nextInt();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                String str = arr[j];
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                res.append(sb.reverse()).append(" ");
//                System.out.print(sb.reverse() + " ");
            }
//            System.out.println();
            res.append("\n");

        }
        System.out.println(res.toString());
    }
}