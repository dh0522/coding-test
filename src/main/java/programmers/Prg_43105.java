package programmers;

public class Prg_43105 {

    public static void main(String[] args) {
        Prg_43105 sol = new Prg_43105();

        int[][] triangle = {{ 7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5 }};
        System.out.println(sol.solution(triangle));
    }
    int max = Integer.MIN_VALUE;
    int[][] arr ;
    private int solution( int[][] triangle ){

        int sum = triangle[0][0]; // 얜 항상 백퍼임
        findMax( 1 , sum , 0 ,0 , triangle );


        return max;
    }
    public void findMax( int depth , int sum, int x, int y, int[][] triangle ){

        if( depth == triangle.length ){
            if( max < sum )
                max = sum;
            return;
        }


        findMax( depth + 1, sum + triangle[x+1][y+1] , x+1, y+1 , triangle );
        findMax( depth+1, sum + triangle[x+1][y] , x+1 , y , triangle );

    }
}