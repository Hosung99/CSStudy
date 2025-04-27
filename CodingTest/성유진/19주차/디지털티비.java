import java.util.*;
import java.io.*;

// 2816
public class 디지털티비 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int idx1 = 0; // KBS1위치
    int idx2 = 0; // KBS1위치
    for (int i = 0; i < N; i++) {
      String chan = br.readLine();
      if (chan.equals("KBS1"))
        idx1 = i;
      if (chan.equals("KBS2"))
        idx2 = i;
    }
    int move1 = idx1;
    int move2 = idx1 > idx2 ? idx2 + 1 : idx2;
    StringBuilder sb = new StringBuilder();
    sb.append("1".repeat(move1));
    sb.append("4".repeat(move1));
    sb.append("1".repeat(move2));
    sb.append("4".repeat(move2 - 1)); // KBS2는 두번째에 위치하면 되므로 -1
    
    System.out.println(sb.toString());
  }
}
