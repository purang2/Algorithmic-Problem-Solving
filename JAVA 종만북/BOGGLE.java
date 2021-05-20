import java.util.*;

public class BOGGLE {

    static int[] dx={-1,-1,-1,1,1,1,0,0};
    static int[] dy={-1,0,1,-1,0,1,-1,1};
    static String[] board;

    public static boolean hasWord(int y,int x, String word){

        if(!inRange(y,x)) return false;

        if(board[y].charAt(x)!=word.charAt(0)) return false;

        if(word.length()==1) return true;

        for(int d=0; d<8;++d){
            int ny= y+dy[d], nx=x+dx[d];

            if(hasWord(ny,nx,word.substring(1)))
                return true;
        }
        return false;
    }

    public static boolean inRange(int y,int x){

        if(y>4 || x>4 || x<0 || y<0) return false;
        else return true;

    }


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);


        int t=sc.nextInt();

        for(int tc=0;tc<t;tc++){

            board=new String[5];
            for(int j=0;j<5;j++)
                board[j]=sc.next();

            String ans="false";

            int n=sc.nextInt();

            for(int d=0;d<n;d++){
            String w=sc.next();

            boolean flag=false;
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(hasWord(i,j,w)) {flag=true; continue;}
                }
            }
            if(flag) System.out.println(w+" YES");
            else  System.out.println(w+" NO");
        }}



    }}
