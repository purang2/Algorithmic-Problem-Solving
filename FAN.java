/**
 * 저는 이 소스 코드를 스스로의 힘으로 작성하였습니다.
 * 만약 소스 코드를 복제한 것이 밝혀지면 어떤 불이익도 감수하겠습니다.
 * @author PURANG2
 */
import java.util.*;

public class FAN{
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            String A=sc.next();
            String B=sc.next();
            int answer=0;
            int Asize=A.length();
            int Bsize=B.length();
            int[] Aarr=new int[Asize];
            int[] Barr=new int[Bsize];
            for(int j=0;j<Asize;j++){
                if(A.charAt(j)=='M') Aarr[j]=1;
            }
            for(int j=0;j<Asize;j++){
                if(B.charAt(j)=='M') Barr[j]=1;
            }

            int start=0;
            while(start>=Asize-Bsize){

                int flag=0;
                for(int k=0;k<Asize;k++){
                    if(Aarr[k]+Barr[k-start]==2){
                        flag=1;k=Asize;
                    }
                }
                if(flag==0) answer++;

                start--;
            }
            System.out.println(answer);
        }

    }
}
