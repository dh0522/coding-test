package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Comparator;

public class Boj_1931 {
    public static void main(String[] args) throws IOException {
        // 한 개의 회의실에서 n개의 회의에 대한 시간표(사용표)
        // 시작시간 , 끝난는 시간
        // 각 회의가 겹치지않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자
        //
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        int n = Integer.parseInt( br.readLine() );
        int[][] meeting= new int[n][2];

        for( int i =0 ; i < n ; i++ ){

            StringTokenizer st = new StringTokenizer(br.readLine());

            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(meeting, new Comparator<int[]>(){

            public int compare( int[] o1, int[] o2 ){

                if(o1[1] == o2[1] )
                    return o1[0]-o2[0];
                return o1[1] - o2[1];
            }

        });

        int answer = 0;
        int time = 0;
        for( int i = 0;i < meeting.length ;i++ ){

            if( meeting[i][0] >= time ){
                time = meeting[i][1];
                answer++;
            }

        }

        System.out.println(answer);
    }
}
