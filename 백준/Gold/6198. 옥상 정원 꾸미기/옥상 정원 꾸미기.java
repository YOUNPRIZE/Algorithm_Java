import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] heights = new int[N];
        
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }
        
        long totalViewCount = calculateTotalViewCount(heights);
        
        System.out.println(totalViewCount);
    }
    
    public static long calculateTotalViewCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        long totalViewCount = 0;
        
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }
            
            totalViewCount += stack.size();
            stack.push(i);
        }
        
        return totalViewCount;
    }
}