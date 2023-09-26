package BOJ.BruteForce;

import java.util.*;
import java.io.*;

public class Boj_9663{
    static int n;
    static int[] arr;
    static int ans = 0 ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        nqueen(0); // num = 지금 놓인 퀸의 개수
        System.out.println(ans);
    }
    public static void nqueen( int num ){

        if( num == n ){
            ans++;
            return;
        }

        for( int i=0; i<n ; i++) {
            arr[num] = i;
            if (isPossible(num)) {

                nqueen(num + 1);
            }
        }

    }
    public static boolean isPossible( int num ){

        //  가로 세로 대각선
        for(int i =0;i < num; i++){
            if( arr[i] == arr[num] ) { // 같은 열 일때
                return false;
            }
            if( Math.abs(num - i) == Math.abs(arr[num]- arr[i]))
                return false;
        }
        return true;

    }

}
