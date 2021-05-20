import java.util.*;

public class JUMPGAME {

    static int n;
    static int[][] board;
    static int[][] cache;

    public static int jump2(int y,int x){



        if(y>= n || x>=n) return 0;
        if(y==n-1 && x==n-1) { cache[y][x]=0; return 1;}

        if(cache[y][x]!=-1) return cache[y][x];

        int jumpSize=board[y][x];

        int j=jump2(y,x+jumpSize);
        int d=jump2(y+jumpSize,x);

        if(j+d>=1) {cache[y][x]=0; return 1;}
        else return 0;

    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        for(int tc=0;tc<t;tc++){


            n=sc.nextInt();
            board=new int[n][n];
            cache=new int[n][n];

            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    cache[i][j]=-1;

            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                board[i][j]=sc.nextInt();


            int ans=jump2(0,0);

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                    System.out.print(cache[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println(ans);
        }



    }
}
