import java.util.*;

public class LIS {

    static int n,lisj;
    static int[] arr;
    static int[] cache;

    public static int lis2(int start){
        if(cache[start]!=0||start>=n) return cache[start];

        int ret=1;

        for(int next= start+1;next<n;++next)
            if(arr[start] < arr[next])
                ret = Math.max(ret,lis2(next)+1);

            return ret;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        for(int tc=0;tc<t;tc++){
            n=sc.nextInt();
            arr=new int[n];
            cache=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
                int max=0;
                for(int j=0;j<n;++j) {
                    lisj= lis2(j);
                    max = Math.max(max, lisj);
                    cache[j]=lisj;
                }
                System.out.println(max);
        }



    }
}
