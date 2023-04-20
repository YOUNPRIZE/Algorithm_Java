import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        int answer = 0;
        boolean flag = false;
        if (pq.peek() >= K) {
            return 0;
        } else {
            while (pq.size() > 1) {
                answer++;
                int ans = 0;
                ans += pq.poll();
                ans += pq.poll() * 2;
                pq.add(ans);
                if (pq.peek() >= K) {
                    flag = true;
                    break;
                }
            }
            if (flag) return answer;
            else return -1;
        } 
    }
}