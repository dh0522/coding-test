package BOJ.BruteForce;

import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Boj_15686 {
    static int n,m ;
    static boolean[] visited;
    static int[][] street;
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> tmp = new ArrayList<>();
    static int mindistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine() );

        n = Integer.parseInt( st.nextToken() );
        m = Integer.parseInt( st.nextToken() );

        street = new int[n][n];

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<n; j++){
                street[i][j] = Integer.parseInt( st.nextToken() );
                if( street[i][j] == 1)
                    home.add(new int[]{i,j});
                else if( street[i][j] == 2)
                    chicken.add(new int[]{i,j} );

            }
        }
        visited = new boolean[chicken.size()];

        delivery(0,0);
        System.out.println(mindistance);

    }

    private static void delivery(int start, int storenum){

        if( storenum == m ){
            int sumdis = 0;
            for( int[] i : home ) {
                int min = Integer.MAX_VALUE;
                for( int[] j : tmp){
                    int d = Math.abs(i[0] - j[0])+ Math.abs(i[1]-j[1]);
                    min = Math.min(d,min);
                }
                sumdis += min;
            }


            mindistance = Math.min( sumdis, mindistance);
            return;

        }
        for( int i = start; i< chicken.size(); i++ ){

            if( !visited[i] ){
                visited[i] = true;
                tmp.add(chicken.get(i));
                delivery( i+1, storenum+1 );
                tmp.remove(chicken.get(i));
                visited[i] = false;

            }

        }



    }
}