import java.io.*;
import java.util.*;

public class BOJ2003 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int result = 0;
    int i = -1;
    int j = 0;
    int curSum = A[j];
    while (j < N) {
      if (curSum >= M) {
        if (curSum == M)
          result += 1;
        i++;
        if (i > j) {
          j++;
          if (j >= N)
            break;
          curSum += A[j];
        }
        curSum -= A[i];
      } else {
        j++;
        if (j >= N)
          break;
        curSum += A[j];
      }

    }
    System.out.println(result);

  }
}