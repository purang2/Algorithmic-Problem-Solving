import java.util.*;

public class _12865 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] w = new int[n];
        int[] v = new int[n];


        //Dp List -> val[index] -> index 무게의 최대 가치
        int[][] dp = new int[k+1][n+1];


        for(int i=0;i<n;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        //int[][] dp = new int[k+1][n+1];

        if(w[0]<=k) {
            dp[w[0]][1] = v[0];
            dp[w[0]][0] = 0;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j+w[i-1]<=k) dp[j+w[i-1]][i] = Math.max(dp[j][i-1]+v[i-1], dp[j+w[i-1]][i]);
                dp[j][i] = Math.max(dp[j][i],dp[j][i-1]);
            }
        }



        int max=-1;
        for(int i=1;i<=k;i++){
            for(int j=1;j<=n;j++){
            max = Math.max(max, dp[i][j]);
            //System.out.println("Val ["+i+"] :"+val[i]);
            }
        }
        System.out.println(max);



    }
}
