package programmers;

public class Prg_12952 {
    public static void main(String[] args) {

        Prg_12952 sol = new Prg_12952();

        System.out.println(sol.solution(4));
    }
    private int answer = 0;
    private int[] arr ;
    private int solution( int n ){

        arr = new int[n];
        queen(0);

        return answer;

    }
    private void queen( int num ){
        // num = 몇번째 퀸

        if( num == arr.length ){
            answer++;
            return;
        }

        for(int i = 0 ; i < arr.length ; i++ ){

            arr[num] = i;

            if( isPossible(num) )
                queen(num+1);

        }
    }
    private boolean isPossible(int num){

        for( int i =0 ; i < num ; i++ ){

            // 행이 같을 순 없겟지 바로 num+1로 넘기니까 그럼 열이 같은지 봐야지
            if( arr[num] == arr[i] )
                return false;

            if( Math.abs(num-i) == Math.abs(arr[num] - arr[i] ) )
                return false;

        }
        return true;
    }
}
