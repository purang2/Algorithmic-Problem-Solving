import java.util.*;

public class POLY {
    static int[][] cache;
    static final int MOD=10*1000*1000;
    static int poly(int n,int first){

        if(n==first) return 1;
        if(cache[n][first]!=-1) return cache[n][first];
        cache[n][first]=0;

        for(int second=1;second<=n-first; ++second){
            int add= second + first -1;
            add *= poly(n-first,second);
            add %= MOD;
            cache[n][first] += add;
            cache[n][first] %= MOD;
        }
        return cache[n][first];
    }

    public static void main(String[] args){


        Scanner sc=new Scanner(System.in);

        int c=sc.nextInt();




        for(int tc=0;tc<c;tc++){
            int n=sc.nextInt();
            cache = new int[101][101];

            for(int i=0;i<101;i++)
                for(int j=0;j<101;j++)
                    cache[i][j]=-1;

            int answer=0;
            for(int i=1;i<=n;i++){
                answer+=poly(n,i);
                answer%=MOD;
            }
            System.out.println(answer);
        }



    }
}