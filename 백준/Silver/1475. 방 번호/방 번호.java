import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[9];
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            int numb = str.charAt(i) - '0';
//            System.out.println(numb);
            if (numb == 6 || numb == 9) num[6]++;
            else num[numb]++;
        }
        num[6] = (num[6] % 2) + (num[6] / 2);
//        System.out.println(Arrays.toString(num));
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            res = Math.max(res, num[i]);
        }
        System.out.println(res);
    }
}