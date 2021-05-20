import java.util.*;

public class TICTACTOE {
    public static void main(String[] args){
     Scanner sc=new Scanner(System.in);

     char[] tic = new char[9];
     String tac;
     //n은 테스트 케이스의 수
     int n=sc.nextInt();
     int[][] set = {
             {0,3,6},{1,4,7},{2,5,8},
             {0,1,2},{3,4,5},{6,7,8},
             {0,4,8},{2,4,6}
     };

     while(n-->0){
         int num_x=0,num_o=0,fin_x=0,fin_o=0;
         //입력 처리 블럭
         for(int i=0;i<3;i++) {
             tac=sc.next();
             for(int j=0;j<3;j++) {
                 tic[i * 3+j] = tac.charAt(j);
                if(tic[i*3+j]=='x'){num_x++;}
                else if(tic[i*3+j]=='o'){num_o++;}
             }
         }

         //fin 처리블럭
         int nf_x=-1, nf_o=-1;
         for(int i=0;i<8;i++){
             int xc=0,oc=0,ec=0,etemp=-1;
             for(int j=0;j<3;j++) {
              if(tic[set[i][j]]=='x') xc++;
              else if(tic[set[i][j]]=='o') oc++;
              else if(tic[set[i][j]]=='.') {ec++; etemp=set[i][j];}
             }
             //nf는 패배를 막기위해 두어야할 위치를 기억
             if(xc==2&&ec==1) {fin_x++; nf_x=etemp;}
             if(oc==2&&ec==1) {fin_o++; nf_o=etemp;}
         }
         //메인 알고리즘
         //winner =0 (D) , 1 (X) , 2(O)
         int winner =-1;
         //turn =1(X) , 2(0)
         int turn =0;
         if(num_x==num_o) turn =1;
         else turn =2;
           int new_cnt=0;
        while(winner==-1){

            //fin 처리후 test구문
            //System.out.println(fin_x+" "+fin_o);

            if(new_cnt>0&&fin_x==0&&fin_o==0) {winner=0; continue;}
            else if(turn==1&&fin_x>=1){winner=1; continue;}
            else if(turn==2&&fin_o>=1){winner=2; continue;}
            else if(turn==1&&fin_o>=2){ winner=2; continue;}
            else if(turn==2&&fin_x>=2){winner=1; continue;}

            else if(turn==1&&fin_o==1){
                //System.out.println("#o:"+nf_o);
                tic[nf_o]='x'; new_cnt++;
                int nnf_x=-1, nnf_o=-1;fin_x=0;fin_o=0;
                for(int i=0;i<8;i++){
                    int xc=0,oc=0,ec=0,etemp=-1;
                    for(int j=0;j<3;j++) {
                        if(tic[set[i][j]]=='x') xc++;
                        else if(tic[set[i][j]]=='o') oc++;
                        else if(tic[set[i][j]]=='.') {ec++; etemp=set[i][j];}
                    }
                    //nf는 패배를 막기위해 두어야할 위치를 기억
                    if(xc==2&&ec==1) {fin_x++; nnf_x=etemp;}
                    if(oc==2&&ec==1) {fin_o++; nnf_o=etemp;}
                }
                turn=2;
                nf_x=nnf_x; nf_o=nnf_o;
                continue;
            }
            else if(turn==2&&fin_x==1){
                //System.out.println("#x:"+nf_x);
                tic[nf_x]='o';new_cnt++;
                int nnf_x=-1, nnf_o=-1;fin_x=0;fin_o=0;
                for(int i=0;i<8;i++){
                    int xc=0,oc=0,ec=0,etemp=-1;
                    for(int j=0;j<3;j++) {
                        if(tic[set[i][j]]=='x') xc++;
                        else if(tic[set[i][j]]=='o') oc++;
                        else if(tic[set[i][j]]=='.') {ec++; etemp=set[i][j];}
                    }
                    //nf는 패배를 막기위해 두어야할 위치를 기억
                    if(xc==2&&ec==1) {fin_x++; nnf_x=etemp;}
                    if(oc==2&&ec==1) {fin_o++; nnf_o=etemp;}
                }
                nf_x=nnf_x; nf_o=nnf_o;
                turn=1;
                continue;
            }
            //else가 잘못된듯..
            /*
            else {
                int put_index = -1, max=-1;
                new_cnt++;
                for(int i=0;i<9;i++){
                    if(tic[i]=='.'){
                        int pin_count=0, make_pin =0;

                        for(int x=0;x<8;x++){
                            int make_count=0;
                            for(int y=0;y<3;y++){
                                if(turn==1) {if(tic[set[x][y]]=='x'|| set[x][y]==i) make_count++;}
                                else if(turn==2) {if(tic[set[x][y]]=='o'|| set[x][y]==i) make_count++;}
                            }
                            if(make_count==3){pin_count++; }
                        }// x off

                        if(max<pin_count) { max=pin_count; put_index=i;}

                    }} // i-off
                //System.out.println("**p_i:"+put_index);
                if(turn==1) tic[put_index]='x';
                if(turn==2) tic[put_index]='o';
                int nnf_x=-1, nnf_o=-1;fin_x=0;fin_o=0;
                for(int i=0;i<8;i++){
                    int xc=0,oc=0,ec=0,etemp=-1;
                    for(int j=0;j<3;j++) {
                        if(tic[set[i][j]]=='x') xc++;
                        else if(tic[set[i][j]]=='o') oc++;
                        else if(tic[set[i][j]]=='.') {ec++; etemp=set[i][j];}
                    }
                    //nf는 패배를 막기위해 두어야할 위치를 기억
                    if(xc==2&&ec==1) {fin_x++; nnf_x=etemp;}
                    if(oc==2&&ec==1) {fin_o++; nnf_o=etemp;}
                }
                nf_x=nnf_x; nf_o=nnf_o;

                turn= (turn%2) +1;
                continue;
            }*/
            else{
                if(num_o<num_x){

                }
            }
        }
        if(winner==0) System.out.println("TIE");
        if(winner==1) System.out.println('x');
        if(winner==2) System.out.println('o');

     }



    }}
