import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> students = new ArrayList<>();
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            students.add(sc.nextInt(), i); 
        }
        for (int i = N - 1; i >= 0; i--) { 
            System.out.print(students.get(i) + " ");
        }
    }
}