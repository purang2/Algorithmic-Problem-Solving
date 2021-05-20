import java.util.*;

public class ITES {

    static long A=1983;
    static long B=0;
    static long g=4294967296L;
    static int index=0;
    public static void RandomGenerator(){

        if(index==0) {
            A = 1983;
            B = (A % 10000) + 1;
            A = (A * 214013 + 2531011) % g;
        }

        else {
            B = (A % 10000) + 1;
            A = (A * 214013 + 2531011) % g;
        }
        index++;
        //System.out.println(B);
    }

    public static void clear(){
        A=1983;
        B=0;
        g=4294967296L;
        index=0;

    }
    public static int count(int k,int n){
        Queue<Long> range=new LinkedList<>();
        int ret=0,sum=0;
        for(int i=0;i<n;i++){
            RandomGenerator();
            sum+=B;
            range.add(B);

            while(sum>k){
                sum-= range.peek();
                range.poll();
            }
            if(sum==k) ret++;
        }
        return ret;
    }
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n,k,tc;
        tc=sc.nextInt();

        for(int t=0;t<tc;t++){

            k=sc.nextInt();
            n=sc.nextInt();

            System.out.println(count(k,n));

            //System.out.println(p1 + " " + p2);
            clear();
        }


    }}
