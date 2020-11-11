
import java.util.Scanner;

public class GO{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String result = "";

        System.out.println("- - - - - - - - - - - - - -\n"
                + "소인수분해를 실행할 정수를 입력하세요.\n"
                + "->");

        int num = Integer.parseInt(sc.nextLine());
        boolean flag = primeNumCheck(num);

        if(flag) {
            int primeNum = 2;

            while(flag) {

                if(num % primeNum == 0) {
                    result += primeNum+" * ";
                    num /= primeNum;
                } else {
                    primeNum = nextNumber(primeNum);
                    continue;
                }

                flag = primeNumCheck(num);
            }
            result += num;
            System.out.println("소인수분해 결과 : "+result+"\n"
                    +"- - - - - - - - - - - - - -");
        } else {
            switch(num) {
                case 0: case 1:
                    System.out.println("입력하신 숫자 "+num+"은 소인수분해가 불가능 합니다.");
                    break;
                default:
                    System.out.println("입력하신 숫자 "+num+"은(는) 소수 이므로 소인수분해가 불가능 합니다!");
                    break;
            }
        }


        sc.close();
    }

    private static boolean primeNumCheck(int num) {
        //2 부터 입력받은 수 -1 까지의 수를 하나씩 대입해서 나머지를 확인한다.
        //나누어 떨어지는게 하나라도 있을 경우 그 수는 소수가 아니다.
        for(int q = 2 ; q < num ; q++) {
            if(num % q == 0) {
                //소수가 아니다.
                return true;
            }
        }
        //소수이다.
        return false;
    }

    private static int nextNumber(int num) {
        //매개변수로 들어온 num 다음의 소수를 찾아서 리턴
        for(int index = num + 1 ; ; index++) {
            if(!primeNumCheck(index)) {
                return index;
            }
        }
    }
}