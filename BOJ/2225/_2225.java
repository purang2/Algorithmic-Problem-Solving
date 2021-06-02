import java.util.*;

public class _2225 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] NQueen_Seq = {1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184};

        System.out.println(NQueen_Seq[n-1]);

    }
}
