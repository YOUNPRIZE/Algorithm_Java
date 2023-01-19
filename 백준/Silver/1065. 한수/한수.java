import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int result = 0;
        if (N < 100) {
        	result = N;
        } else if (N == 1000) {
        	result = 144;
        } 
        else {
        	result = 99;
        	int hund = Character.getNumericValue(str.charAt(0));
        	for (int j = 1; j <= hund; j++) {
//	        	for (int i = 0; i * j < 10; i++) {
//	        		System.out.println(i);
//	        		if (i == 0) {
//	        			if (j*100+j*10+j <= N) result++;
//	        		}
//	        		else {
//	        			System.out.println(j);
//	        			
//	        			if (j - 2*i >= 0) {
//	        				System.out.println((j*100)+((j-i)*10)+(j-2*i));
//	        				if ( (j*100)+((j-i)*10)+(j-2*i) <= N ) result++;
//	        			}
//	        			if (j + 2*i < 10) {
//	        				System.out.println((j*100)+((j+i)*10)+(j+2*i));
//	        				if ( (j*100)+((j+i)*10)+(j+2*i) <= N ) result++;
//	        			}
//	        		}
//	        	}
        		if (j*100+j*10+j <= N) result++;
        		for (int i = 1; j - 2*i >= 0; i++) {
        			if ( (j*100)+((j-i)*10)+(j-2*i) <= N ) result++;
        		}
        		for (int i = 1; j + 2*i < 10; i++) {
        			if ( (j*100)+((j+i)*10)+(j+2*i) <= N ) result++;
        		}
        	}
        }
        System.out.println(result);
    }
}