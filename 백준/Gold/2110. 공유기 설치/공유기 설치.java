import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();  
        int C = input.nextInt(); 
        int[] homeList = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            homeList[i] = input.nextInt();
        }

        Arrays.sort(homeList);  

        int maxResult = 0;

        int left = 1;
        int right = homeList[N] - homeList[1];
        int d = 0;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int start = homeList[1];
            int count = 1; 
            for (int i = 1; i <= N; ++i) {
                d = homeList[i] - start; 
                if (d >= mid) {  
                    count++;
                    start = homeList[i]; 
                }
            }

            if (count >= C) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}