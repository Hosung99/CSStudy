import java.util.*;
import java.util.stream.*;

public class BOJ2661 {
  static int[] result;
  static int N;

  static void printArr(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
  }

  static boolean check(int[] arr, int size) {
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        int diff = j - i;
        if (j + diff > size)
          break;
        boolean equal = true;
        for (int k = 0; k < diff; k++) {
          if (arr[i + k] != arr[j + k])
            equal = false;
        }
        if (equal)
          return false;
      }
    }
    return true;
  }

  public static void makeArr(int d) {
    if (d == N) {
      if (check(result, d)) {
        printArr(result, d);
        System.exit(0);
      }
      return;
    }

    for (int j = 1; j <= 3; j++) {
      if (d == 0 || (result[d] == 0 && check(result, d-1))) {
        result[d] = j;
        makeArr(d + 1);
        result[d] = 0;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    N = scanner.nextInt();

    result = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      result[i] = 0;
    }
    makeArr(0);
  }
}
