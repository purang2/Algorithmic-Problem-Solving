import java.util.*;

public class DARPA {

    static int n,m;
    static double[] arr;
    //static int cameras;
    public static boolean decision(int cameras,double gap){

        //카메라를 설치할 수 있을 때마다 설치하는 탐욕적 알고리즘
        double limit=-1;
        int installed =0;

        for(int i=0;i<arr.length; ++i){
            if(limit <=arr[i]){
                ++installed;
                //arr[i]+gap 이후는 되어야 카메라를 설치할 수 있다.
            limit = arr[i] + gap;
            }
        }
        //결과적으로 cameras대 이상을 설치할 수 있으면 성공
        return installed >= cameras;
    }

    public static double optimize(int cameras,int epoch){
        double lo=0,hi=241;

        for(int it=0;it<epoch;++it){
            double mid =(lo+hi)/2.0;
            //간격이 mid 이상이 되도록 할 수 있으면 답은 [mid,hi]에 있다
            if(decision(cameras,mid)) lo=mid;
            //간격이 mid 이상이 되도록 할 수 없으면 답은 [lo,mid]에 있다
            else
                hi=mid;
        }
        return lo;
    }

    public static void main(String[] args){


        Scanner sc= new Scanner(System.in);
        int tc=sc.nextInt();

        for(int t=0;t<tc;t++){

            n=sc.nextInt();
            m=sc.nextInt();

            arr=new double[m];

            for(int i=0;i<m;i++){
                arr[i]=sc.nextDouble();
            }
            double ans =optimize(n,50);



            System.out.printf("%.2f\n",ans);
        }


    }
}
