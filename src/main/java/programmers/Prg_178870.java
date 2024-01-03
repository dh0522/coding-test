package programmers;

public class Prg_178870 {
    public static void main(String[] args) {
        Prg_178870 sol = new Prg_178870();

        int[] ans1 = sol.solution( new int[] {1, 2, 3, 4, 5 } , 7);
        int[] ans2 = sol.solution( new int[]{ 1, 1, 1, 2, 3, 4, 5 } , 5 );

        for( int i : ans1 )
            System.out.print( i +" ");
        System.out.println();
        for( int i : ans2 )
            System.out.print( i +" ");
    }
    private int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while( true ){

            if( sum == k && len > right-left ){
                answer[0] = left;
                answer[1] = right;
                len = right - left;
            }

            if( left == sequence.length && right == sequence.length )
                break;

            if( sum < k && right < sequence.length ){
                right ++;
                if( right < sequence.length )
                    sum += sequence[right];
            }
            else{

                if(left < sequence.length )
                    sum -= sequence[left];
                left++;

            }

        }
        return answer;
    }
}