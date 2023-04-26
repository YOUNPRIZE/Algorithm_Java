import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        int[] bitCount = new int[32];

        for (int i = 0; i < n; i++) {
            int temp = sequence[i];
            int j = 0;
            while (temp > 0) {
                bitCount[j] += (temp % 2);
                temp = temp / 2;
                j++;
            }
        }

        int maxBitCount = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] > maxBitCount) {
                maxBitCount = bitCount[i];
            }
        }
        System.out.println(maxBitCount);
    }
}