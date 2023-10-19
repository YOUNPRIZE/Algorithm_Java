import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visit;
    static ArrayList<String> allRoutes;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visit = new boolean[tickets.length];
        allRoutes = new ArrayList<>();
        int cnt = 0;
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(allRoutes);
        answer = allRoutes.get(0).split(" ");
        // System.out.println(answer);
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allRoutes.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visit[i] = false;
            }
        }
    }
}