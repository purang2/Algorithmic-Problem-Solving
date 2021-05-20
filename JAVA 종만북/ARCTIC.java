import java.util.*;

public class ARCTIC {

    static int n;
    static double[][] dist;

    public static boolean decision(double d){
        boolean[] visited =new boolean[n];
        visited[0]=true;
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(0);
        int seen =0;
        while(!q.isEmpty()){
            int here=q.peek();
            q.poll();
            ++seen;
            for(int there=0; there <n; ++there)
                if(!visited[there] && dist[here][there] <= d){
                    visited[there] = true;
                    q.add(there);
                }

        }
        return seen==n;
    }

    public static double optimize(){
        double lo=0,hi=1416.00;
        for(int it=0;it<100;++it){
            double mid= (lo+hi)/2;

            if(decision(mid))
                hi=mid;
            else
                lo=mid;
        }
        return hi;
    }

    static double[] arr_x;
    static double[] arr_y;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int tc=sc.nextInt();
        for(int t=0;t<tc;t++){
            n=sc.nextInt();
            arr_x=new double[n];
            arr_y=new double[n];
            dist =new double[n][n];
            for(int i=0;i<n;i++){
                arr_x[i]=sc.nextDouble();
                arr_y[i]=sc.nextDouble();
            }

            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    dist[i][j]=Math.sqrt((arr_x[i]-arr_x[j])*(arr_x[i]-arr_x[j])+(arr_y[i]-arr_y[j])*(arr_y[i]-arr_y[j]));

            double ans=optimize();
            System.out.printf("%.2f\n",ans);

        }
    }
}
