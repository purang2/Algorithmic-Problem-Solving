/**
 * 저는 이 소스 코드를 스스로의 힘으로 작성하였습니다.
 * 만약 소스 코드를 복제한 것이 밝혀지면 어떤 불이익도 감수하겠습니다.
 * @author 이은찬
 */
import java.util.*;

public class DRAGON2 {

    static int c,n,p,l;
    static String expand_x = "XF+YF";
    static String expand_y = "FX-FY";
    static int[] len = new int[51];

    public static void make_len(){
        len[0]=1;
        for(int i=1;i<=50;i++) len[i] =Math.min(1000000000,(len[i-1]*2)+2);
    }

    public static char expand(String dragon, int gen, int skip){
        if(gen==0) {
            if (skip <= dragon.length()) return dragon.charAt(skip);
        }
        for(int i=0; i<dragon.length(); i++){
            if(dragon.charAt(i)=='X' || dragon.charAt(i)=='Y'){
                if(skip>= len[gen]) skip-=len[gen];
                else if(dragon.charAt(i)=='X')
                    return expand(expand_x,gen-1,skip);
                else
                    return expand(expand_y,gen-1,skip);
            }
            else if (skip>0) --skip;
            else return dragon.charAt(i);
        }
        return '#';
    }
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        c=sc.nextInt();
        make_len();
        for(int tc=0;tc<c;tc++) {
            n = sc.nextInt();
            p = sc.nextInt();
            l = sc.nextInt();

            for(int i=0;i<l;i++){
                System.out.print(expand("FY",n,p+i-1));
            }
            System.out.println();
        }
    }

}
