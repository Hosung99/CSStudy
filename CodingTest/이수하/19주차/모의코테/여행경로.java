import java.util.Arrays;

class Solution {
    static String[] res;
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        String[] curPath = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            } else {
                return a[0].compareTo(b[0]);
            }
        });

        for (int i = 0; i < tickets.length; i++) {
            if (!tickets[i][0].equals("ICN")) { continue ; }
            curPath[0] = tickets[i][0];
            visited[i] = true;
            dfs(i, 1, tickets, curPath);
            visited[i] = false;
        }

        answer = res;
        return answer;
    }

    public void dfs(int previous, int depth, String[][] tickets, String[] curPath) {
        if (depth >= tickets.length) {
            if (res == null) {
                curPath[tickets.length] = tickets[previous][1];
                res = Arrays.copyOf(curPath, curPath.length);
            }
            return ;
        }

        for (int next = 0; next < tickets.length; next++) {
            if (previous == next) continue;
            if (visited[next] == true) { continue; }
            if (!tickets[previous][1].equals(tickets[next][0])) continue;
            curPath[depth] = tickets[next][0];
            visited[next] = true;
            dfs(next, depth + 1, tickets, curPath);
            visited[next] = false;
        }
    }
}