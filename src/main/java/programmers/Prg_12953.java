package programmers;

public class Prg_12953 {

    public static void main(String[] args) {

        Prg_12953 sol = new Prg_12953();

        System.out.println(sol.solution(new int[] { 2,6,8,14 }));
        System.out.println(sol.solution(new int[] { 1,2,3 }));
    }

    private int solution( int[] arr ){
        int answer = 0;

        for( int i =0 ;i < arr.length;  i++ ){
            if( i == 0 ){
                answer= (arr[i]*arr[i+1]) / gcd(arr[i],arr[i+1]);
            }else{
                answer = (answer * arr[i] ) / gcd(answer , arr[i] );
            }
        }
        return answer;
    }

    private int gcd(int a , int b){

        for( int i = Math.min(a,b) ; i >= 2 ; i-- ){
            if( a%i == 0 && b %i == 0 ){
                return i ;
            }
        }

        return 1;
    }
}