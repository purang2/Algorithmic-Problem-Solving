import java.util.*;

public class Prime{

    static int n;

    public static boolean erato(int num){
       for(int i=2;i*i<num;i++){

           if(num%i==0){
               return false;
           }
       }
       System.out.println(num);
       return true;

    }

    public static int getSo(int num){
        int cnt=0;
        for(int i=2;i<=num;i++) {

            while(num%i==0){
                //System.out.print(i+" ");
                cnt++;
                num=num/i;
                //break;
            }
        }
        return cnt;
    }


    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);



        n=sc.nextInt();
        int[] arr =new int[n];

        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        int ans=0;

        int cntans=0;
        for(int i=0;i<n;i++) {
            if (erato(arr[i])) {
                ans++;

            }
            else {
                System.out.print("#");
                cntans=Math.max(cntans,getSo(arr[i]));
                System.out.println();

            }



        }
        System.out.println(ans);

        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println(cntans);

    }
}
