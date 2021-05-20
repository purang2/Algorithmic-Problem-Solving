import java.util.*;

public class BOARDCOVER{


    static int[][][] coverType ={
            {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}
    };
    static String[] board;

    static boolean set(int y,int x, int type,int delta){
      boolean ok=true;

      for(int i=0;i<3;++i){
          int ny = y+coverType[type][i][0];
          int nx = x+coverType[type][i][1];
          if(ny<0 || ny >= board.length || nx <0||
          nx >= board[0].length())
              ok=false;
          else if((board[ny].charAt(nx)-'0')+delta>1){
              //board[ny].charAt(nx)+= delta;
          }
      }
      return false;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);


        int t=sc.nextInt();

        for(int tc=0;tc<t;tc++) {


        }


    }}
