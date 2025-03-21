import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int word_cnt, K, max = 0;
    static boolean[] alphabet = new boolean[26];
    static List<Set<Character>> word_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        word_cnt = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < word_cnt; i++) {
            tk = new StringTokenizer(br.readLine());
            String word_string = tk.nextToken().substring(4);
            word_string = word_string.substring(0, word_string.length() - 4);
            Set<Character> word = new HashSet<>();
            for (char ch : word_string.toCharArray()) {
                word.add(ch);
            }
            word_list.add(word);
        }

        alphabet['a' - 'a'] = true;
        alphabet['c' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;

        bfs(0, 0);

        System.out.print(max);
    }

    static void bfs(int idx, int count) {
        if (count == K - 5) {
            int cnt = 0;
            for (Set<Character> word : word_list) {
                if (able_check(word) == true) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (alphabet[i] == false) {
                alphabet[i] = true;
                bfs(i + 1, count + 1);
                alphabet[i] = false;
            }
        }
    }

    static boolean able_check(Set<Character> word) {
        for (char c : word) {
            if (alphabet[c - 'a'] == false) {
                return false;
            }
        }
        return true;
    }
}