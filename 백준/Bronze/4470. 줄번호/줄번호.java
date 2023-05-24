import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= N; i++) {
        	System.out.print(i + ". ");
        	System.out.println(sc.nextLine());
        }
    }
}