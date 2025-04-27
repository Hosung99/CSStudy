import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> arr = new ArrayList<>();
        int kbs1 = 0, kbs2 = 0;
        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
            if (arr.get(i).equals("KBS1")) {
                kbs1 = i;
            }
        }
        String res = "";
        for (int i = 0; i < kbs1; i++) {
            res += "1";
        }
        for (int i = 0; i < kbs1; i++) {
            res += "4";
        }
        arr.remove(kbs1);
        arr.add(0, "KBS1");

        for (int i = 0; i < N; i++) {
            if (arr.get(i).equals("KBS2")) {
                kbs2 = i;
                break ;
            }
        }
        for (int i = 0; i < kbs2; i++) {
            res += "1";
        }

        for (int i = 0; i < kbs2 - 1; i++) {
            res += "4";
        }

        System.out.print(res);
    }
}