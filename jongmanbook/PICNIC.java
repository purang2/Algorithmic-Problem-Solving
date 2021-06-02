

/**
 * 저는 이 소스 코드를 스스로의 힘으로 작성하였습니다.
 * 만약 소스 코드를 복제한 것이 밝혀지면 어떤 불이익도 감수하겠습니다.
 * @author 이은찬
 */

import java.util.*;

public class PICNIC {

    static boolean[] hasPair;
    static int n;
    static boolean[][] areFriends;
    static int countPairings(boolean hasPair[]){
        //boolean finished =true;

        int firstFree = -1;
        for(int i=0;i<n;++i){
            if(!hasPair[i]){
                firstFree=i;
                break;
            }
        }
        if(firstFree==-1) return 1;


        //for(int i=0;i<n;++i) if(!hasPair[i]) finished= false;
       //if(finished) return 1;
       int ret=0;

       for(int i=firstFree+1;i<n;++i) {
           if (!hasPair[i] && areFriends[firstFree][i]) {
               hasPair[i] = hasPair[firstFree] = true;
               ret += countPairings(hasPair);
               hasPair[i] = hasPair[firstFree] = false;
           }
       }
       return ret;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        int case_number=sc.nextInt();
        for(int tc=0;tc<case_number;tc++){
            int numOfPlayers=sc.nextInt();
            int numOfPairs=sc.nextInt();
            n=numOfPlayers;

            areFriends=new boolean[numOfPlayers][numOfPlayers];
            hasPair=new boolean[numOfPlayers];
            for(int i=0;i<numOfPairs;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                areFriends[a][b]=true;
                areFriends[b][a]=true;
            }
            boolean[] taken=new boolean[n];
            System.out.println(countPairings(taken));
        }


    }}
