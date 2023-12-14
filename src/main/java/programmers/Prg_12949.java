package programmers;

public class Prg_12949 {
    public static void main(String[] args) {

        Prg_12949 sol = new Prg_12949();

        int[][] ans1 = sol.solution(new int[][]{ {1,4},{3,2},{4,1} } , new int[][]{ {3,3},{3,3} });
        int[][] ans2 = sol.solution(new int[][]{{2,3,2},{4,2,4},{3,1,4} } , new int[][]{ {5,4,3},{2,4,1},{3,1,1} });

        for(int i =0 ; i< ans1.length; i++ ){
            for (int j = 0;j < ans1[0].length;j ++ )
                System.out.print(ans1[i][j]+" ");
            System.out.println();
        }

        System.out.println();

        for(int i =0 ; i< ans2.length; i++ ){
            for (int j = 0;j < ans2[0].length;j ++ )
                System.out.print(ans2[i][j]+" ");
            System.out.println();
        }
    }

    private int[][] solution(int[][] arr1 , int[][] arr2 ){

        int[][] answer = new int[arr1.length][arr2[0].length];
        for( int i =0 ; i < arr1.length ;i ++ ){

            for( int j = 0; j< arr2[0].length; j++ ){

                for( int k = 0 ; k < arr1[0].length; k ++ ){

                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
