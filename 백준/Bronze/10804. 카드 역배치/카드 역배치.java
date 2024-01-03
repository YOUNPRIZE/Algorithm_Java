import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
 
public class Main {
  public static void main(String args[]) throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     
    int arr[] = new int[21];
    for(int i = 1; i<21; i++) {
      arr[i] = i;
    }
    for(int i = 0; i<10; i++) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int a1 = Integer.parseInt(tokenizer.nextToken());
      int a2 = Integer.parseInt(tokenizer.nextToken());
       
      int mid = (a2 - a1) / 2;
       
      for(int j = 0; j<=mid; j++) {
        int tmp = arr[a1 + j];
        arr[a1 + j] = arr[a2 - j];
        arr[a2 - j] = tmp;
      }
    }
    for(int i = 1; i<21; i++) {
      System.out.print(arr[i]+" ");
    }
  }
}