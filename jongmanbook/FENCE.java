import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FENCE{

    static int C, N;
    static int[] h;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {

        C = Integer.parseInt(br.readLine());

        for (int t = 1; t <= C; t++) {

            int ans = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            h = new int[N];

            for (int i = 0; i < N; i++)
                h[i] = Integer.parseInt(st.nextToken());

            System.out.println(solve(0, N - 1));
        }
    }

    public static int solve(int left, int right) {

        if (left == right)
            return h[left];

        int mid = (left + right) / 2;
        int result = Math.max(solve(left, mid), solve(mid + 1, right));

        int low = mid;
        int high = mid + 1;
        int height = Math.min(h[low], h[high]);

        result = Math.max(result, 2 * height);

        while (low > left || high < right) {

            if (high < right && (low == left || h[high + 1] > h[low - 1])) {
                high += 1;
                height = Math.min(height, h[high]);
            } else {
                low -= 1;
                height = Math.min(height, h[low]);
            }
            result = Math.max(result, (high - low + 1) * height);
        }
        return result;
    }

}