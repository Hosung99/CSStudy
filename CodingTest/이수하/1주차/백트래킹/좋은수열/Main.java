import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int NUM_MIN = 1;
    private static final int NUM_MAX = 3;
    static int n;
    static int[] goodSequence;
    static boolean endFlag;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        goodSequence = new int[n];

        BackTracking(0);
    }

    private static void BackTracking(int k) throws IOException {
        if (k == n) {
            for (int i = 0; i < goodSequence.length; i++)
                bw.write(String.valueOf(goodSequence[i]));
            bw.flush();
            endFlag = true;
            return;
        }

        for (int i = NUM_MIN; i <= NUM_MAX; i++) {
            if (endFlag)
                return;
            goodSequence[k] = i;
            if (!checkBedSequence((k + 1) / 2, k + 1))
                continue;
            BackTracking(k + 1);
        }
    }

    private static boolean checkBedSequence(int maxSubSequenceLength, int currentSequenceLength) { //2 , 4
        for (int subSequenceLength = 1; subSequenceLength <= maxSubSequenceLength; subSequenceLength++) {
            int[] frontSubsequence = Arrays.copyOfRange(goodSequence, currentSequenceLength - subSequenceLength * 2, currentSequenceLength - subSequenceLength);
            int[] backSubsequence = Arrays.copyOfRange(goodSequence, currentSequenceLength - subSequenceLength, currentSequenceLength);
            if (Arrays.equals(frontSubsequence, backSubsequence))
                return false;
        }
        return true;
    }
}
