import java.util.*;

public class trianglepath{

    public static void main(String[] args){
        int[] input;
        int[] myArr;
        int[] now;
        int[] inst;
        int cnt,max,index;
        Scanner sc=new Scanner(System.in);

        int tc=sc.nextInt();

        for(int testcase=0;testcase<tc;testcase++){
            int n=sc.nextInt(); //삼각형 크기
            int size=(n*(n+1))/2; //삼각형 총 원소 갯수 [sigma(1~n)의 값]
            input = new int[size];
            myArr = new int[n];
            now = new int[n];
            inst = new int[n];
            cnt=0;
            int answer=0;

            //삼각형 모든 원소를 입력 순서대로 저장한다.
            //총 원소 갯수를 알 수 있고,
            //공간 낭비를 줄이기 위해 2차원 배열이 아닌 1차원 배열로 선언
            for(int i=0;i<size;i++){
                input[i]=sc.nextInt();
            }

            //삼각형의 층별로 step을 나눠 myArr을 업데이트함
            //최종 myArr의 최대값을 답으로 채택하면 됨
            for(int step=1;step<=n;step++){
                //1)NOW 배열을 업데이트
                //index=0;
                for(int i=0;i<step;i++){
                    now[i]=input[cnt++];
                }
                //2)inst 업데이트
                for(int i=0;i<n;i++){
                    if(i==0) inst[0]=myArr[0];
                    else inst[i]=Math.max(myArr[i-1],myArr[i]);

                }
                //3)myArr 업데이트
                for(int i=0;i<step;i++){
                        myArr[i]=now[i]+inst[i];
                }

                //0) print 검사
                System.out.println("#Case "+ step);
                for(int i=0;i<n;i++)
                    System.out.print(myArr[i]+" ");
                System.out.println();

            }
            //정답 채택
            for(int i=0;i<n;i++)
                answer=Math.max(answer,myArr[i]);
            System.out.println(answer);
        }



        //end
    }}
