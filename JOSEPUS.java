import java.util.*;


public class JOSEPUS {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int n,k,tc;
        LinkedList<Integer> q;
        //boolean[] q;

        tc=sc.nextInt();

        for(int t=0;t<tc;t++){

            n=sc.nextInt();
            k=sc.nextInt();
            q=new LinkedList<>();

            for(int i=2;i<=n;i++)
                q.add(i);


            int index=0;

            while(q.size()>2) {
                index= (index+k-1)%q.size();
                //System.out.println(index);
                q.remove(index);
            }

            //System.out.println("QS# :"+q.size());

            int p1=q.poll();
            int p2=q.poll();

            System.out.println(p1 + " " + p2);

        }


    }}
