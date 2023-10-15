import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        Arrays.sort(times);
        // System.out.println(times[times.length-1]);
        long right = (long) times[times.length-1] * n;
        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            long ppl = 0;
            for (long time : times) {
                ppl += mid / time;
                if (ppl >= n) break;
            }
            if (ppl >= n) {
                answer = mid;
                right = mid - 1;
            } else if (ppl < n) {
                left = mid + 1;
            }
        }
        return answer;
    }
}