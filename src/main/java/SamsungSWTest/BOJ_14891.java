package SamsungSWTest;
import java.util.*;
import java.io.*;
public class BOJ_14891 {
    static int[][] gear ;
    static int[] turn;
    public static void main(String[] args ) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        gear = new int[4][8];
        for(int i=0; i< 4; i++){
            String tmp = br.readLine();
            for(int j= 0; j<8; j++){
                gear[i][j] = tmp.charAt(j)-'0';

            }
        }

        int k = Integer.parseInt(br.readLine());
        for( int i = 0;i< k ; i++) {
            st = new StringTokenizer(br.readLine());
            turn = new int[4];

            int index = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            turn[index] = d;
            check(index);


            for(int j=0; j<4; j++){
                if(turn[j] == 1)
                    turnright(j);
                else if( turn[j] == -1 )
                    turnleft(j);
            }

        }




        int ans = 0;
        for(int i=0; i<4; i++){
            if( gear[i][0] == 1)
                ans+= Math.pow(2,i);
        }
        System.out.println(ans);

    }
    static void check(int index){
        for( int j = index-1; j>=0 ; j--){
            if(gear[j+1][6] != gear[j][2] ){
                turn[j] = -turn[j+1];
            }
            else {
                break;
            }
        }

        for( int j =index+1; j<4; j++ ){
            if(gear[j-1][2] != gear[j][6] ) {
                turn[j] = -turn[j-1];
            }
            else {
                break;
            }
        }

    }

    static void turnright(int j){
        // j는 몇번째 톱니바퀴인지
        int tmp = gear[j][7];
        for(int i =7; i>0;i--){
            gear[j][i] = gear[j][i-1];
        }
        gear[j][0] = tmp;
    }

    static void turnleft(int j){
        int tmp = gear[j][0];
        for(int i =0; i<7;i++)
            gear[j][i] = gear[j][i+1];

        gear[j][7] = tmp;

    }
}

