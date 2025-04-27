import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] house;
    public static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            house[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(house);

        int low = 0;
        int hi = house[house.length - 1] - house[0] + 1;
        while (low < hi) {
            int mid = (low + hi) / 2;

            if (installCnt(mid) < C) {
                hi = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.print(hi - 1);
    }

    public static int installCnt(int dist) {
        int installedCnt = 0;
        int lastInstall = 0;

        installedCnt++;
        lastInstall = house[0];
        for (int i = 1; i < house.length; i++) {
            int currentHome = house[i];

            if (currentHome - lastInstall >= dist) {
                installedCnt++;
                lastInstall = currentHome;
            }
        }
        return installedCnt;
    }
}