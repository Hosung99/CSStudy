import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //15686
    public static int N, M;
    public static List<List<Integer[]>> chickenPermutation = new ArrayList<>();
    public static List<Integer[]> chicken = new ArrayList<>();
    public static List<Integer[]> house = new ArrayList<>();
    public static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                if (num == 2)
                    chicken.add(new Integer[]{i, j});
                else if (num == 1)
                    house.add(new Integer[]{i, j});
            }
        }
        //M개의 치킨집 조합을 찾기 유사 N과 M
        makeChickenPermutation(0, new ArrayList<>());

        //치킨집 조합으로 최소 도시의 치킨거리 계산
        for (List<Integer[]> hen : chickenPermutation)
            res = Math.min(res, calculator(hen, house));
        System.out.println(res);
    }

    private static void makeChickenPermutation(int length, List<Integer> tmpChicken) {
        if (length == M) {
            List<Integer[]> array = new ArrayList<>();
            for (Integer i : tmpChicken)
                array.add(chicken.get(i));
            chickenPermutation.add(array);
            return;
        }
        int start = 0;
        if (length != 0)
            start = tmpChicken.get(length - 1) + 1;
        for (int i = start; i < chicken.size(); i++) {
            tmpChicken.add(i);
            makeChickenPermutation(length + 1, tmpChicken);
            tmpChicken.remove(tmpChicken.size() - 1);
        }
    }

    public static int calculator(List<Integer[]> chickens, List<Integer[]> houses) {
        int sum = 0;
        for (Integer[] house : houses) {
            int minLength = Integer.MAX_VALUE;
            for (Integer[] chicken : chickens) {
                int min = Math.abs(house[1] - chicken[1]) + Math.abs(house[0] - chicken[0]);
                minLength = Math.min(minLength, min);
            }
            sum += minLength;
        }
        return sum;
    }
}
