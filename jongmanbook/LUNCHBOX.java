
/**
 * 저는 이 소스 코드를 스스로의 힘으로 작성하였습니다.
 * 만약 소스 코드를 복제한 것이 밝혀지면 어떤 불이익도 감수하겠습니다.
 * @author 이은찬
 */

import java.util.*;

class box implements Comparable<box>{
    int m;
    int e;
    public box(int m,int e){
        this.m=m;
        this.e=e;
    }
    public int compareTo(box o){
        if(this.e>o.e){
            return -1*(this.e-o.e);
        }
        else if(this.e==o.e){
            return -1*(this.m-o.m);
        }
        else{
            return -1*(this.e-o.e);
        }
    }
}

public class LUNCHBOX{

    static box[] arr;
    static int answer=-1;
    static int n;
    static int[] m,e;

    public static void findAnswer(){

        int ans=0;
        int len =arr.length;
        for(int i=0;i<len+1;i++){
            if(i==0) ans+=arr[0].m;
            else if(i==len) ans+=arr[i-1].e;
            else ans+=Math.max(arr[i].m,arr[i-1].e);
        }
        answer=ans;
    }

    public static void printArray(){

        System.out.println("*PRINT*");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].m+","+arr[i].e);
        }

    }

    public static void greedy_fineTuning(){
        //맨처음 데우는 시간과 맨 마지막 먹는 시간을 줄여야 올바른 답이 나오는데
        //그리디로는 그게 힘드므로 파인튜닝 과정을 거쳤습니다

        int target=arr[0].e;
        int len=arr.length;
        int idx=-1;
        int swap_a,swap_b;
        for(int i=1;i<len;i++){
            if(arr[i].e!=target) {idx=i-1; break;}
        }
        if(idx>=0) {
            swap_a = arr[idx].m;
            swap_b = arr[0].m;

            arr[0].m=swap_a;
            arr[idx].m=swap_b;
        }
    }

    public static int alg_in_book(){
        int answer=0;
        int len = arr.length;
        int b=0;
        for(int i=0;i<len;i++) {
            b+=arr[i].m;
            answer= Math.max(answer,b+arr[i].e);
        }
        return answer;
    }

    public static void main(String[] args){

    Scanner sc=new Scanner(System.in);

    int tc=sc.nextInt();

    for(int tc_=0;tc_<tc;tc_++){
        n=sc.nextInt();
        arr=new box[n];
        m=new int[n];
        e=new int[n];

        for(int i=0;i<n;i++) m[i]=sc.nextInt();
        for(int i=0;i<n;i++) e[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            arr[i]=new box(m[i],e[i]);

        Arrays.sort(arr);
        //greedy_fineTuning();
        //printArray();
        //findAnswer();
        System.out.println(alg_in_book());
        //System.out.println(answer);
    }
    }}

