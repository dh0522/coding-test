package programmers;

public class Prg_43105 {

    public static void main(String[] args) {
        Prg_43105 sol = new Prg_43105();

        int[][] triangle = {{ 7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5 }};
        System.out.println(sol.solution(triangle));
    }
    public int solution(int[][] triangle) {


         int[][] dp =  new int[triangle.length][triangle.length];
         dp[0][0] = triangle[0][0];


         for( int i = 0; i < triangle.length; i++ ){

             for( int j =0 ; j< triangle[i].length; j++ ) {

                 if (i == 0 && j == 0) {
                     dp[i][j] = triangle[i][j];
                     continue;
                 }
                 if (j == 0) {
                     dp[i][j] = triangle[i][j] + dp[i-1][j];
                     continue;
                 }
                 if (j == i) {

                     dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                     continue;
                 }

                 dp[i][j] = Math.max( triangle[i][j] + dp[i-1][j-1] , triangle[i][j] + dp[i-1][j] );

             }
         }
         int answer = 0;
         for( int i = 0; i <triangle.length ; i++ ){

             answer = Math.max(answer, dp[triangle.length-1][i] );
         }

         return answer;
    }}