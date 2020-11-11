import java.util.*;

public class QUADTREE{
    public static String str;
    public static int it;


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        for(int i=0;i<n;i++){
            it=0;

            str=sc.next();
            String result = reverse();
            System.out.println(result);

        }

    }
    public static String reverse(){
        char head=str.charAt(it);

        if(head== 'b' || head == 'w'){
            return head+"";
        }
        it++;
        String part1=reverse();
        it++;
        String part2=reverse();
        it++;
        String part3=reverse();
        it++;
        String part4=reverse();
        return "x"+part2+part1+part4+part3;
    }


}