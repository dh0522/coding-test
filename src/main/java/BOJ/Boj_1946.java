package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1946 {
    /**
     * 대기업 신입 사원 채용
     * 1차서류 + 2차 면접
     *
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); // test개수

        for( int i = 0; i< t ;i ++ ){

            int n = Integer.parseInt(br.readLine()); // 지원자의 수

            int[][] test = new int[n][2];

            for( int j =0 ;j < n; j ++ ) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int docu = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                test[j][0] = docu;
                test[j][1] = interview;

            }


            Arrays.sort(test, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            // 서류 1등의 면접점수
            int firstdocu = test[0][1];
            int answer = 1;

            for( int j =1; j< n; j++ ){

                // 서류 1등의 면접점수보다 면접점수가 작다면 두 점수가 다 작다.
                // 따라서 점수가 더 크다면 얘는 합격한 사람
                if( firstdocu > test[j][1] ){
                    answer ++;
                    firstdocu = test[j][1];
                }

            }

            System.out.println(answer);
        }

    }
}
