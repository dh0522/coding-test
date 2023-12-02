package programmers;

public class Prg_136798 {
    public static void main(String[] args) {

        Prg_136798 sol = new Prg_136798();

        System.out.println(sol.solution(5,3,2));
        System.out.println(sol.solution(10,3,2));
    }

    private int solution( int number , int limit , int power){
        int answer = 0;
        int[] arr = new int[number];

        for( int i = 1 ; i <= number; i++ ){

            for( int j = 1 ; j <= Math.sqrt(i)  ; j++ ){
                if( i == 1 ){
                    arr[i-1]++;
                    continue;
                }
                if( j*j == i ){
                    arr[i-1]++;
                    break;
                }
                if( i % j == 0)
                    arr[i-1] += 2;
            }

        }

        for( int i = 0 ;i < arr.length; i ++ ){

            if( arr[i] > limit ){
                arr[i] = power;
            }
            answer += arr[i];
        }


        return answer;
    }
}