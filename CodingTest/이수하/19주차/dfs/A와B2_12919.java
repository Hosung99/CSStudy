import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        String s = tk.nextToken();
        tk = new StringTokenizer(br.readLine());
        String t = tk.nextToken();

        dfs(s, t);

        System.out.print(flag ? "1" : "0");
    }

    public static void dfs(String s, String t) {
        if (flag) { return ; }

        if (s.length() == t.length()) {
            if (s.equals(t)) { flag = true; }
            return ;
        }

        //1번조건
        if (t.charAt(t.length() - 1) == 'A') {
            dfs(s, t.substring(0, t.length() - 1));
        }

        //2번조건
        if (t.charAt(0) == 'B') {
            String sub = t.substring(1);
            StringBuilder sb = new StringBuilder(sub);
            dfs(s, sb.reverse().toString());
        }
    }
}