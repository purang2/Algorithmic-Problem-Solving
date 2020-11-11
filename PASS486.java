import java.util.*;

public class PASS486 {

    static int n,lo,hi;
    static int TM=1000*1000*10;
    static int minFactor[];
    static int minFactorPower[];
    static int factors[];

    public static void getFactorsSmart(){
        factors[1]=1;
        for(int n=2; n<= hi+1; ++n){
            if(minFactor[n]==n){
                minFactorPower[n]=1;
                factors[n]=2;
            }
            else{
                int p = minFactor[n];
                int m = n/p;
                if(p != minFactor[m])
                    minFactorPower[n]=1;
                else
                    minFactorPower[n]=minFactorPower[m]+1;
                int a = minFactorPower[n];
                factors[n]=(factors[m]/a)*(a+1);
            }
        }
    }

    public static void getFactorsBrute(){
        factors= new int[TM+1];
        for(int div=1;div<=TM;++div){
            for(int multiple=div;multiple<=TM;multiple += div)
                factors[multiple]+=1;
        }
    }
    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);

        int tc=sc.nextInt();

        getFactorsBrute();
        for(int t=0;t<tc;t++){
            n=sc.nextInt();lo=sc.nextInt();hi=sc.nextInt();

            //minFactor=new int[hi+1];
            //minFactorPower=new int[hi+1];
            //factors=new int[hi+1];
            //getFactorsSmart();
            int answer=0;
            for(int x=lo;x<=hi;x++){
                if(factors[x]==n) answer++;
            }
            System.out.println(answer);
        }
    }
}
