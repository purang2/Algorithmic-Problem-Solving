/**
 * 저는 이 소스 코드를 스스로의 힘으로 작성하였습니다.
 * 만약 소스 코드를 복제한 것이 밝혀지면 어떤 불이익도 감수하겠습니다.
 * @author 이은찬
 */



import java.util.Scanner;
import java.util.Arrays;

public class STRJOIN {

    static int[] arr;
    static int n,min1,min2;
    static int maxnum=1234567890;
    static int answer=-1;
    public static void runJoin(int cnt,int ans,int len){
        Arrays.sort(arr);

        if(cnt==len-1) answer=ans;

        else {
            //temp처럼 저장
            min1 = arr[0];
            min2 = arr[1];
            arr[0] = min1 + min2;
            arr[1] = maxnum;
            runJoin(cnt + 1, ans + arr[0],len);
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tcnum=sc.nextInt();
        while(tcnum-->0) {
            n = sc.nextInt();
            arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            //runJoin(0,0,arr.length);
            //초깃값으로 start

            Arrays.sort(arr);

            for(int i=0;i<n;i++)
                System.out.print(arr[i]+" ");

            //System.out.println(answer);
        }

    }
}