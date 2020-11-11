
import java.util.*;
public class DRAGON {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String block,answer;
        int c=sc.nextInt();
        int n,p,l,h=0;
        for(int tc=0;tc<c;tc++){
            n=sc.nextInt();
            p=sc.nextInt();
            l=sc.nextInt();

            block="1";
            if(n==0) block="0";//"FX"

                h=Math.min(28,n);
            for(int i=2;i<=h;i++){
                    String tmp="";
                    double pop=6*Math.pow(2,h-i+1);
                    for(int j=0;j<block.length();j++){
                        System.out.println(block.length());
                        char at=block.charAt(j);
                        if(p>pop) {p-=pop; break;}
                        else if(at=='1'){tmp+="12";}
                        else if(at=='2'){tmp+="14";}
                        else if(at=='3'){tmp+="32";}
                        else if(at=='4'){tmp+="34";}
                    }
                    block=tmp;
                } //n세대의 드래곤 커브 작성 완료
            System.out.println("*:"+block);
                String s1="+FX+YF",s2="+FX-YF",s3="-FX+YF",s4="-FX-YF";
                String ans="";
                for(int i=0;i<block.length();i++){
                    char at=block.charAt(i);
                    if(at=='1'){ans+=s1;}
                    else if(at=='2'){ans+=s2;}
                    else if(at=='3'){ans+=s3;}
                    else if(at=='4'){ans+=s4;}
                }
                if(block=="0") {ans="FX";
                    for(int i=0;i<l;i++){
                        System.out.print(ans.charAt(p+i-1));
                    }
                }
                else
                for(int i=1;i<=l;i++){
                    System.out.print(ans.charAt(p+i-1));
                }
                System.out.println();



        }//end-of-tc
    }}
