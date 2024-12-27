import java.util.*;
import java.util.stream.*;

public class BOJ15666 {
  static int n, m;
  static int[] numbers;
  static List<Integer> result = new ArrayList<>();

  static void bt(int depth) {
    if (depth == m){
      for (int x: result) {
        System.out.print(x + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 0; i < n; i++) {
      if (result.size() == 0 || (result.get(result.size() - 1) <= numbers[i])) {
        result.add(numbers[i]);
        bt(depth + 1);
        result.remove(result.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    n = scanner.nextInt();
    m = scanner.nextInt();
    scanner.nextLine();
    String input = scanner.nextLine();
    Set<Integer> numSet = new TreeSet<>();

    for (String numStr: input.split(" ")) {
      numSet.add(Integer.parseInt(numStr));
    }
    numbers = numSet.stream().mapToInt(Integer::intValue).toArray();
    n = numbers.length;

    bt(0);

    scanner.close();
  }
}
