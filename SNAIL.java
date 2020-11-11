import java.util.*;

public class SNAIL {

    static double[][] cache;
    static int n,m,max=0;
    public static double run(int day, int num){
        if(day==m) {
            if(num>=n)return 1;
            else return 0;
        }
        if(cache[day][num]>=0.0){
            return cache[day][num];
        }
        cache[day][num]= 0.75*run(day+1,num+2)+0.25*run(day+1,num+1);
        return cache[day][num];
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int c=sc.nextInt();
        for(int tc=0;tc<c;tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            cache = new double[m+1][(2 * m) + 1];

            for(int i=0;i<cache.length;i++){
                for(int j=0;j<cache[i].length;j++){
                    cache[i][j] =-1.0;
                }
            }
            System.out.printf("%.8f\n",run(0,0));
        }

    }
}