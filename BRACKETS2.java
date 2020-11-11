import java.util.*;

public class BRACKETS2 {

    public static boolean wellMatched(String str){
        //char[] opening={'(','{','['};
        //char[] closing={')','}',']'};
        Stack<Character> stack = new Stack<>();
        int d=0;

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='(' || c=='{'|| c=='[')
                stack.add(c);
            else{
                if(stack.size() == 0) return false;

                if(stack.peek()=='(') d=0;
                if(stack.peek()=='{') d=1;
                if(stack.peek()=='[') d=2;

                if((c==')'&&d==0)||(c=='}'&&d==1)||(c==']'&&d==2))
                    stack.pop();
                else return false;

            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        for(int t=0;t<tc;t++){
            String s=sc.next();

            boolean ans = wellMatched(s);

            if(ans==true) System.out.println("YES");
            else System.out.println("NO");
        }


    }}
