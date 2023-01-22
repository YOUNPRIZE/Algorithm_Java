import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int C = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < C; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] arr = new int[1000];
        	int num = Integer.parseInt(st.nextToken()); // 학생 수
        	int sum = 0; // 점수 총합
        	// 학생 점수 입력
        	for (int j = 0; j < num; j++) {
        		arr[j] = Integer.parseInt(st.nextToken());
        		sum += arr[j];
        	}
        	
        	double aver = sum / num; // 평균
        	int cnt = 0; // 평균 점수를 넘은 학생 수
        	
        	for (int j = 0; j < num; j++) {
        		if (arr[j] > aver) cnt++;
        	}
        	
        	double pp = (cnt / (double) num) * 100; // 평균을 넘은 학생 비율
        	System.out.println(String.format("%.3f%%", pp));
        }
	}
}