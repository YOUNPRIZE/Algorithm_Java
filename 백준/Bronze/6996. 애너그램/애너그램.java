import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
     
    public static String sortStr(String str){
        char[] sol = str.toCharArray();
        Arrays.sort(sol);
        return new StringBuilder(new String(sol)).toString();
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int N = Integer.parseInt(sc.next());
         
        for(int i=0; i < N; i++) {
            String A = sc.next();
            String B = sc.next();
 
            System.out.print(A + " & " + B + " are ");
            if(!sortStr(A).equals(sortStr(B))) {
                System.out.print("NOT ");
            }
            System.out.println("anagrams.");
        }
         
 
    }
}