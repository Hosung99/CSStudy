import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없다면 변환 불가능
        if (!Arrays.asList(words).contains(target)) return 0;

        // 단어 연결 그래프 생성
        Map<String, List<String>> map = new HashMap<>();
        String[] allWords = Arrays.copyOf(words, words.length + 1);
        allWords[words.length] = begin;

        for (String word1 : allWords) {
            for (String word2 : allWords) {
                if (!word1.equals(word2) && canConvert(word1, word2)) {
                    map.computeIfAbsent(word1, k -> new ArrayList<>()).add(word2);
                }
            }
        }

        // BFS
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distance = new HashMap<>();
        queue.offer(begin);
        distance.put(begin, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int dist = distance.get(current);

            if (current.equals(target)) return dist;

            for (String next : map.getOrDefault(current, new ArrayList<>())) {
                if (!distance.containsKey(next)) {
                    distance.put(next, dist + 1);
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    // 한 글자만 다른지 체크
    private boolean canConvert(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
