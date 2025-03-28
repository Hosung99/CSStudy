import java.util.*;
import java.io.*;

public class 스도쿠 {
  static int[][] board = new int[9][9];

  public static boolean possible(int curI, int curJ, int num) {
    // 가로
    for (int j = 0; j < 9; j++) {
      if (board[curI][j] == num)
        return false;
    }
    // 세로
    for (int i = 0; i < 9; i++) {
      if (board[i][curJ] == num)
        return false;
    }
    // 3X3
    int stI = curI - curI % 3;
    int stJ = curJ - curJ % 3;
    for (int i = stI; i < stI + 3; i++) {
      for (int j = stJ; j < stJ + 3; j++) {
        if (board[i][j] == num)
          return false;
      }
    }
    return true;
  }

  public static void solve(int d) {
    // 확인할 위치의 인덱스 계산
    int i = d / 9;
    int j = d % 9;

    // 모든 칸을 전부 확인했으면 결과값 출력
    if (i == 9) {
      printBoard();
      System.exit(0);
    }

    // 이미 채워진 칸이면 다음 칸 확인
    if (board[i][j] != 0) {
      solve(d + 1);
      return;
    }

    // 1~9 중에서 가능한 숫자 채우기
    for (int n = 1; n <= 9; n++) {
      if (possible(i, j, n)) {
        board[i][j] = n;
        solve(d + 1);
        board[i][j] = 0;
      }
    }
  }

  public static void printBoard() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        sb.append(board[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.println(sb.toString());
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    solve(0);
  }
}
