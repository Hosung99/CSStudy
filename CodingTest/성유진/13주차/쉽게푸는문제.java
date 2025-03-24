import java.io.*;
import java.util.*;

// 1292
public class 쉽게푸는문제 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int[] arr = new int[1001];
    
    int num = 1;
    int numCnt = 0;
    for (int i = 1; i <= 1000; i++) {
      arr[i] = num;
      numCnt++;
      if (numCnt == num) {
        num++;
        numCnt = 0;
      }
    }

    int result = 0;
    for (int i = A; i <= B; i++) {
      result += arr[i];
    }
    System.out.println(result);
  }
}
