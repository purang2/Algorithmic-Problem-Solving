import java.util.*;
import java.io.*;

public class Nexpressing {

    static Queue<Integer> q = new LinkedList<Integer>();
    static int answer =-1;
    static int new_var;

    public static void main(String[] args){


        //5,31168 , -1
        //5,1010 , 7
        //1,1121 ->7
        //7 , 7776 ->6

        System.out.println(solution(4,16));
    }

    public static void run(int degree,int N, int number){

        if(degree>8 || answer != -1) return;

        int var = q.poll();
        //System.out.print(var+" ");
        new_var = var*10 + N; q.add(new_var);
        if(new_var==number) { answer =degree+1; return;}
        new_var = var+N; q.add(new_var);
        if(new_var==number) { answer =degree+1; return;}
        new_var = var-N; q.add(new_var);
        if(new_var==number) { answer =degree+1; return;}
        new_var = var*N; q.add(new_var);
        if(new_var==number) { answer =degree+1; return;}
        new_var = var/N; q.add(new_var);
        if(new_var==number) { answer =degree+1; return;}

    }

    public static int solution(int N, int number) {
        //Queue<Integer> q = new LinkedList<Integer>();

        q.offer(N);
        if(N==number) return 1;
        int repeat_num=1;
        run(1,N,number);

        if(answer!=-1) return answer;

        for(int i=2;i<=8;i++){
            repeat_num*=5;

            System.out.println("*");
            for(int j=0;j<repeat_num;j++){
                run(i,N,number);
                if(answer!=-1) return answer;
            }
            if(answer!=-1) return answer;
        }


        return answer;
    }
}


/*memo

55555555
5555
+,-,*,/,공백

5@5@5@5 => 7
5@5@5@5@5@5@5@5 ->15
5^4 = 25*25 = 625;
5^5 = 3125;
5^6 = 15625;
5^7 = 78125;


5 5 + 5 / 5

12 , 5
[0] => 5
[1] => 55 , 10 ,0,  25 , 1
[2] => 555 , 60, 50 , 265 , 11,
       105 , 15  , 5 , 50 , 2 ,
       255 , 30  , 20  , 125 , 5,
       15  , 6   , -4  , 5   , 0,


1개 , 5개 , 5^2개


5^8 = > 390,625 -> 배열로 만들시 공간효율 bad,

-> Queue로 구현해보기


*/